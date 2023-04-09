package com.example.lhs.redisJedis.repository;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.lhs.redisJedis.domain.RedisDefault;
import com.google.gson.Gson;

@Repository
public class RedisRepository {

	@Value("${spring.redis.timeout}")
	private int redisTimeOut;

	@Autowired
	RedisTemplate redisTemplate;


	public Object saveOrUpdate(String haskey, Object model) {
		redisTemplate.opsForValue().set(haskey, new Gson().toJson(model));
		redisTemplate.expire(haskey, redisTimeOut, TimeUnit.MINUTES);
		return model;
	}

	public RedisDefault getDataByHaskeyForString(String haskey) {
		try {
			String value = (String) redisTemplate.opsForValue().get(haskey);
			if (value != null) {
				RedisDefault redisDefault = new RedisDefault();
				redisDefault.setKey(haskey);
				redisDefault.setValue(value);
				return redisDefault;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	public RedisDefault getDataByHaskeyForEntity(String haskey, Class<?> classOfT) {
		try {
			String value = (String) redisTemplate.opsForValue().get(haskey);
			if (value != null) {
				RedisDefault redisDefault = new RedisDefault();
				redisDefault.setKey(haskey);
				redisDefault.setValue(new Gson().fromJson(redisTemplate.opsForValue().get(haskey).toString(), classOfT));
				return redisDefault;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean deleteDataByHaskey(String haskey) {
		redisTemplate.opsForValue().getAndDelete(haskey);
		return true;
	}

}
