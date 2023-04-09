package com.example.lhs.redisJedis.service;

import org.springframework.http.ResponseEntity;

import com.example.lhs.redisJedis.domain.Employee;

public interface EmployeeService {

	ResponseEntity getByEnrollment(String enrollment);
	ResponseEntity update(Employee employee);

	ResponseEntity create(Employee employee);

	ResponseEntity deleteByEnrollment(String enrollment);
}
