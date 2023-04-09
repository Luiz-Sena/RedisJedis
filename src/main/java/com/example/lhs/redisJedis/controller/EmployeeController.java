package com.example.lhs.redisJedis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.lhs.redisJedis.domain.Employee;
import com.example.lhs.redisJedis.restApi.EmployeeApi;
import com.example.lhs.redisJedis.service.EmployeeService;

@RestController
public class EmployeeController implements EmployeeApi {

	@Autowired
	private EmployeeService employeeService;

	@Override
	public ResponseEntity getByEnrollment(String enrollment){
		return employeeService.getByEnrollment(enrollment);
	}

	@Override
	public ResponseEntity update(Employee employee) {
		return employeeService.update(employee);
	}

	@Override
	public ResponseEntity create(Employee employee){
		return employeeService.create(employee);
	}

	@Override
	public ResponseEntity deleteByEnrollment(String enrollment){
		return employeeService.deleteByEnrollment(enrollment);
	}
}
