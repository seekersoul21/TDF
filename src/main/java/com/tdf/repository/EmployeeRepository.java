package com.tdf.repository;

import com.tdf.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
    List<Employee> findByFileId(String fileId);
}
