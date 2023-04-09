package com.example.lhs.redisJedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class RedisJedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisJedisApplication.class, args);
	}

}
