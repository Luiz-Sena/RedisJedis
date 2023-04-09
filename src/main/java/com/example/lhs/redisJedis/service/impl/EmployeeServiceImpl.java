package com.example.lhs.redisJedis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.lhs.redisJedis.domain.Employee;
import com.example.lhs.redisJedis.domain.RedisDefault;
import com.example.lhs.redisJedis.repository.RedisRepository;
import com.example.lhs.redisJedis.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private RedisRepository redisRepository;

	@Override
	public ResponseEntity getByEnrollment(String enrollment) {
		RedisDefault redis = redisRepository.getDataByHaskeyForEntity(enrollment, Employee.class);

		if (redis != null) {
			return ResponseEntity.ok().body(redis.getValue());
		}

		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity update(Employee employee) {
		Object redis = redisRepository.saveOrUpdate(employee.getEnrollment(), employee);

		if (redis != null) {
			return ResponseEntity.ok().body(employee);
		}

		return ResponseEntity.ok().body("Update Fail");
	}

	@Override
	public ResponseEntity create(Employee employee) {
		Object redis =  redisRepository.saveOrUpdate(employee.getEnrollment(), employee);

		if (redis != null) {
			return ResponseEntity.ok().body(employee);
		}

		return ResponseEntity.ok().body("Create fail.");

	}

	@Override
	public ResponseEntity deleteByEnrollment(String enrollment){
		Object redis = redisRepository.getDataByHaskeyForString(enrollment);

		if (redis != null) {
			redisRepository.deleteDataByHaskey(enrollment);
			return ResponseEntity.ok().body(String.format("Delete %s success", enrollment));
		}

		return ResponseEntity.ok().body(String.format("Delete %s fail", enrollment));
	}
}
