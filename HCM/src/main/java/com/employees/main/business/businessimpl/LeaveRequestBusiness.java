package com.employees.main.business.businessimpl;

import com.employees.main.business.dto.LeaveRequestDTO;
import com.employees.main.business.ibusiness.IBusinessLeaveRequest;
import com.employees.main.entities.Employee;
import com.employees.main.entities.LeaveRequest;

import com.employees.main.repositories.RequestLeaveRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
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
public class LeaveRequestBusiness implements IBusinessLeaveRequest {

     final RequestLeaveRepository leaveRequestRepository;
     JavaMailSender javaMailSender;

     final ModelMapper mapper;

    public LeaveRequestBusiness(RequestLeaveRepository leaveRequestRepository, JavaMailSender javaMailSender, ModelMapper mapper) {
        this.leaveRequestRepository = leaveRequestRepository;
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
    public LeaveRequest createRequest(LeaveRequestDTO leaveRequestDTO) {
        LeaveRequest leaveRequest = new LeaveRequest(

                leaveRequestDTO.getId(),
                "Await For Validation",
                leaveRequestDTO.getMotif(),
                24,
                leaveRequestDTO.getStartDate(),
                leaveRequestDTO.getStart(),
                leaveRequestDTO.getEndDate(),
                leaveRequestDTO.getEnd(),
                (long) leaveRequestDTO.getEndDate().getDate() - (long) leaveRequestDTO.getStartDate().getDate(),
                24,
                leaveRequestDTO.getEmployee(),
                leaveRequestDTO.getComments(),
                leaveRequestDTO.getValidatedBy(),
                leaveRequestDTO.getRejectedBy(),
                "No",
                leaveRequestDTO.getUser()

        );
        return leaveRequestRepository.save(leaveRequest);
    }

    @Override
    public LeaveRequest createRequestAsDraft(LeaveRequestDTO leaveRequestDTO) {
        LeaveRequest leaveRequest = new LeaveRequest(
                leaveRequestDTO.getId(),
                "Draft",
                leaveRequestDTO.getMotif(),
                24,
                leaveRequestDTO.getStartDate(),
                leaveRequestDTO.getStart(),
                leaveRequestDTO.getEndDate(),
                leaveRequestDTO.getEnd(),
                (long) leaveRequestDTO.getEndDate().getDate() - (long) leaveRequestDTO.getStartDate().getDate(),
                24,
                leaveRequestDTO.getEmployee(),
                leaveRequestDTO.getComments(),
                leaveRequestDTO.getValidatedBy(),
                leaveRequestDTO.getRejectedBy(),
                "Yes",
                leaveRequestDTO.getUser()
        );
        return leaveRequestRepository.save(leaveRequest);
    }

    @Override
    public List<LeaveRequest> findRequests() {
        return leaveRequestRepository.findAll();
    }



    @Override
    public List<LeaveRequest> findAscendingRequest() {
        return leaveRequestRepository.findAll(Sort.by("startDate"));
    }

    @Override
    public List<LeaveRequest> findDescendingRequest() {
        return leaveRequestRepository.findAll(Sort.by("endDate"));
    }

    @Override
    public LeaveRequest updateRequest(LeaveRequestDTO leaveRequestDTO, String id) {
        LeaveRequest lv = this.mapper.map(leaveRequestDTO,LeaveRequest.class);
        Optional<LeaveRequest>editRequest= leaveRequestRepository.findById(id);
        return (editRequest.isPresent()? leaveRequestRepository.save(lv):null);
    }

    @Override
    public LeaveRequest validateRequest(LeaveRequestDTO leaveRequestDTO, String id) {
        LeaveRequest lv = this.mapper.map(leaveRequestDTO, LeaveRequest.class);
        sendEmail("Validate Request",EmailTemplate1.template,lv.getEmployee().getEmployeeEmail());

        Optional<LeaveRequest> validateRequest = leaveRequestRepository.findById(id);
        lv.setRequestStatus("Validate");
        lv.setRemainderQuantity( 24 - lv.getDuration());
        return (validateRequest.isPresent()
                ? leaveRequestRepository.save(lv) : null);

    }

    @Override
    public LeaveRequest rejectRequest(LeaveRequestDTO leaveRequestDTO, String id) {
        LeaveRequest lv = this.mapper.map(leaveRequestDTO, LeaveRequest.class);

        sendEmail("Reject Request",EmailTemplate2.template,lv.getEmployee().getEmployeeEmail());

        Optional<LeaveRequest> rejectRequest = leaveRequestRepository.findById(id);
        lv.setRequestStatus("Rejected");
        return (rejectRequest.isPresent()? leaveRequestRepository.save(lv): null);
    }

    @Override
    public LeaveRequest cancelRequest(LeaveRequestDTO leaveRequestDTO, String id) {

        LeaveRequest lv = this.mapper.map(leaveRequestDTO, LeaveRequest.class);
        Optional<LeaveRequest> cancelRequest = leaveRequestRepository.findById(id);
        lv.setRequestStatus("Canceled");
        return (cancelRequest.isPresent()? leaveRequestRepository.save(lv): null);
    }

    @Override
    public LeaveRequest archiveRequest(LeaveRequestDTO leaveRequestDTO, String id) {
        LeaveRequest lv = this.mapper.map(leaveRequestDTO, LeaveRequest.class);
        Optional<LeaveRequest> archiveRequest = leaveRequestRepository.findById(id);
        lv.setIsArchived("Yes");
        return (archiveRequest.isPresent()? leaveRequestRepository.save(lv): null);
    }

    @Override
    public LeaveRequest restoreRequest(LeaveRequestDTO leaveRequestDTO, String id) {
        LeaveRequest lv = this.mapper.map(leaveRequestDTO, LeaveRequest.class);
        Optional<LeaveRequest> restoreLeaveRequest = leaveRequestRepository.findById(id);
        lv.setIsArchived("No");
        return (restoreLeaveRequest.isPresent()? leaveRequestRepository.save(lv): null);
    }

    @Override
    public String deleteRequest(String id) {
        leaveRequestRepository.deleteById(id);
        return "Operation Deleted Successfuly";
    }

    @Override
    public Optional<LeaveRequest> getRequest(String id) {
        return leaveRequestRepository.findById(id);
    }

    @Override
    public List<LeaveRequest> getAllByRequestStatus() {
        return leaveRequestRepository.findAllByRequestStatus("Validate");
    }

    @Override
    public List<LeaveRequest> getByEmployee(Employee employee) {
        return leaveRequestRepository.findLeaveRequestsByEmployee(employee);
    }

}
