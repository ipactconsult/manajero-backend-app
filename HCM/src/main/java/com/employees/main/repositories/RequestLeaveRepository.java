package com.employees.main.repositories;

import com.employees.main.entities.Employee;
import com.employees.main.entities.LeaveRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RequestLeaveRepository extends MongoRepository<LeaveRequest, String> {
    List<LeaveRequest> findAllByRequestStatus(String requestStatus);
    List<LeaveRequest> findLeaveRequestsByEmployee(Employee employee);
}
