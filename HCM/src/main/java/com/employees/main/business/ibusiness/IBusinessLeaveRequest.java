package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.LeaveRequestDTO;
import com.employees.main.entities.Employee;
import com.employees.main.entities.LeaveRequest;

import java.util.List;
import java.util.Optional;

public interface IBusinessLeaveRequest {

    LeaveRequest createRequest(LeaveRequestDTO leaveRequestDTO);
    LeaveRequest createRequestAsDraft(LeaveRequestDTO leaveRequestDTO);
    List<LeaveRequest>findRequests();
    List<LeaveRequest>findAscendingRequest();
    List<LeaveRequest>findDescendingRequest();
    LeaveRequest updateRequest(LeaveRequestDTO leaveRequestDTO, String id);
    LeaveRequest validateRequest(LeaveRequestDTO leaveRequestDTO, String id);
    LeaveRequest rejectRequest(LeaveRequestDTO leaveRequestDTO, String id);
    LeaveRequest cancelRequest(LeaveRequestDTO leaveRequestDTO, String id);
    LeaveRequest archiveRequest(LeaveRequestDTO leaveRequestDTO, String id);
    LeaveRequest restoreRequest(LeaveRequestDTO leaveRequestDTO, String id);
    String deleteRequest(String id);
    Optional<LeaveRequest> getRequest(String id);
    List<LeaveRequest>getAllByRequestStatus();
    List<LeaveRequest> getByEmployee(Employee employee);
}
