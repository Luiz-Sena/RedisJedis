package com.example.lhs.redisJedis.restApi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lhs.redisJedis.domain.Employee;

@RequestMapping("/employee")
public interface EmployeeApi {

	@GetMapping("/enrollment/{enrollment}")
	ResponseEntity getByEnrollment(@PathVariable String enrollment);

	@PutMapping
	ResponseEntity update(@RequestBody Employee employee);

	@PostMapping
	ResponseEntity create(@RequestBody Employee employee);

	@DeleteMapping("/enrollment/{enrollment}")
	ResponseEntity deleteByEnrollment(@PathVariable String enrollment);
}
