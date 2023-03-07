package com.employees.main.business.businessimpl;

import com.employees.main.business.dto.PayDTO;
import com.employees.main.business.ibusiness.IBusinessPay;
import com.employees.main.entities.Contract;
import com.employees.main.entities.Pay;
import com.employees.main.repositories.ContractRepository;
import com.employees.main.repositories.PayRepository;
import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.model.checkout.Session;
import org.modelmapper.ModelMapper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class PayBusinessImpl implements IBusinessPay {

    private static void init()
    {
        Stripe.apiKey = "sk_test_6BoRQXIx89ypSbKukxn81sqQ00kFhWhVEq";
    }

    private static Gson gson = new Gson();

   final PayRepository payRepository;

   final ContractRepository contractRepository;

   final ModelMapper modelMapper;

   final JavaMailSender javaMailSender;

    public PayBusinessImpl(PayRepository payRepository, ContractRepository contractRepository, ModelMapper modelMapper, JavaMailSender javaMailSender) {
        this.payRepository = payRepository;
        this.contractRepository = contractRepository;
        this.modelMapper = modelMapper;
        this.javaMailSender = javaMailSender;
    }


    public void sendEmail(String subject,String body,String email){
        MimeMessage emailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(emailMessage, true);
            helper.setSubject(subject);
            helper.setTo(email);
            helper.setText(body, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        javaMailSender.send(emailMessage);
    }

    @Override
    public float gainCalculate(Pay pay) {
        return pay.getContract().getOverallMonthlyCost()+ pay.getPrimeConventionnelle()+ pay.getPrimeNonConventionnelle();
    }

    public String payment(PayDTO payDTO) throws StripeException {
        Pay pay= this.modelMapper.map(payDTO,Pay.class);

        init();
        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(payDTO.getSuccessUrl())
                .setCancelUrl(pay.getCancelUrl())
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                                .setCurrency(payDTO.getCurrency()).setAmount((long) payDTO.getNetSalary())
                                .setDescription(String.valueOf(SessionCreateParams.LineItem.PriceData.ProductData
                                        .builder().setName(pay.getContract().getEmployee().getEmployeeName()).build()))
                                .build())
                .build();

        Session session = Session.create(params);
        Map<String,String> responseData = new HashMap<>();
        responseData.put("id",session.getId());
        return gson.toJson(responseData);
    }

    @Override
    public Pay addPay(PayDTO payDTO, String idContract)  {
        Contract contractOptional =   contractRepository.findById(idContract).orElse(null);
        Pay pay= this.modelMapper.map(payDTO,Pay.class);
        pay.setContract(contractOptional);
        pay.setPaymentMode(payDTO.getPaymentMode());


        pay.setBaseSalary(pay.getContract().getOverallMonthlyCost());

        pay.setGain(gainCalculate(pay));

        float cnssToPay= (float) ((0.0918*gainCalculate(pay))+(0.1657*gainCalculate(pay))+(0.02*gainCalculate(pay)));
        pay.setCnss(cnssToPay);

        float cnssEmployeur = (float) (0.1657*gainCalculate(pay));

        float cnamTobePaid= (float) (0.02*gainCalculate(pay));
        pay.setCnam(cnamTobePaid);

        float tfpTobePaid= (float) (0.01*gainCalculate(pay));
        pay.setTfp(tfpTobePaid);


        pay.setSalaryCost((float) (gainCalculate(pay)+cnssEmployeur+cnamTobePaid+tfpTobePaid + gainCalculate(pay)*0.01));

        float annual=gainCalculate(pay)*12;
        pay.setSalaryAnnual(annual);

        float annualCnss= (float) (annual*0.0918);
        pay.setCnssAnnuel(annualCnss);

        float calculateW= annual-annualCnss;
        pay.setBrutSalaryImposed(calculateW);

        float calculateWwithTfp= Math.round(calculateW - tfpTobePaid - 2000000);
        pay.setNetSalaryImposed(calculateWwithTfp);

        if(pay.getContract().getEmployee().getEmployeeMaritalStatus().equals("Maried")){
              pay.setNetSalaryImposed(Math.round(pay.getNetSalaryImposed()-300000));
        if (pay.getContract().getEmployee().getEmployeeNbKids() != 0) {
            float getNbKidsByEmployee= (float) pay.getContract().getEmployee().getEmployeeNbKids()* 100000;
            pay.setNetSalaryImposed(Math.round(pay.getNetSalaryImposed()-getNbKidsByEmployee));
        }

        }


        float css = (float) (pay.getNetSalaryImposed() * 0.01);
        pay.setCss(css);


        pay.setNetSalary(pay.getNetSalaryImposed()/12);
        payRepository.save(pay);

        //payment(payDTO);


        sendEmail("Employee PaySheet",EmailTemplate3.template,pay.getContract().getEmployee().getEmployeeEmail());
        return pay;
    }

    @Override
    public List<Pay> findData() {
        return payRepository.findAll();
    }

    @Override
    public Optional<Pay> getItem(String id) {
        return payRepository.findById(id);
    }


}

