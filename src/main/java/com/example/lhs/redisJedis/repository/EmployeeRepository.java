package com.example.lhs.redisJedis.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.lhs.redisJedis.entity.EmployeeCache;

public interface EmployeeRepository extends CrudRepository<EmployeeCache, Integer>{
	Optional<EmployeeCache> findByEnrollment(String enrollment);
}
