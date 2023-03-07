package com.employees.main.business.businessimpl;

import com.employees.main.business.dto.EvaluationDTO;
import com.employees.main.business.ibusiness.IEvaluationBusiness;
import com.employees.main.entities.Employee;
import com.employees.main.entities.Evaluation;
import com.employees.main.repositories.EmployeeRepository;
import com.employees.main.repositories.EvaluationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EvaluationBusinessImpl implements IEvaluationBusiness {

    private final EvaluationRepository er;

    private final EmployeeRepository employeeRepository;

     JavaMailSender javaMailSender;

     final ModelMapper mapper;

    public EvaluationBusinessImpl(EvaluationRepository er, EmployeeRepository employeeRepository, JavaMailSender javaMailSender, ModelMapper mapper) {
        this.er = er;
        this.employeeRepository = employeeRepository;
        this.javaMailSender = javaMailSender;
        this.mapper = mapper;
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
    public Evaluation add(EvaluationDTO evaluationDTO, String id) {
        Evaluation ev = this.mapper.map(evaluationDTO, Evaluation.class);
        Optional<Employee> employee= employeeRepository.findById(id);
      //  ev.setEmployee(employee.get());
        er.save(ev);
        sendEmail("New Evaluation Test",EmailTemplate.template,employee.get().getEmployeeEmail());
        return ev;
    }

    @Override
    public Evaluation edit(EvaluationDTO evaluationDTO, String id) {
        Evaluation ev = this.mapper.map(evaluationDTO, Evaluation.class);
        Optional<Evaluation> item = er.findById(id);
        return (item.isPresent()? er.save(ev):null);
    }

    @Override
    public Optional<Evaluation> show(String id) {
        return er.findById(id);
    }

    @Override
    public List<Evaluation> showAll() {
        return er.findAll();
    }

    @Override
    public Evaluation archive(EvaluationDTO evaluationDTO, String id) {
        Evaluation ev = this.mapper.map(evaluationDTO, Evaluation.class);
        Optional<Evaluation> item = er.findById(id);
        ev.setIsArchived("Yes");
        return (item.isPresent()? er.save(ev):null);
    }

    @Override
    public Evaluation restore(EvaluationDTO evaluationDTO, String id) {
        Evaluation ev = this.mapper.map(evaluationDTO, Evaluation.class);
        Optional<Evaluation> item = er.findById(id);
        ev.setIsArchived("No");
        return (item.isPresent()? er.save(ev):null);
    }

    @Override
    public void remove(String id) {
        er.deleteById(id);
    }
}
