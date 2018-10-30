package com.asiainfo.qm.manage.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class RedisCommand {


	@Autowired
	StringRedisTemplate stringRedisTemplate;

	
	public String get(String key) throws Exception {
		 return stringRedisTemplate.opsForValue().get(key);
	}
	
	public void set(String key,String value,int expireSeconds) throws Exception{
		stringRedisTemplate.opsForValue().set(key, value, expireSeconds, TimeUnit.SECONDS);
	}
	
	public void set(String key,String value) throws Exception{
		stringRedisTemplate.opsForValue().set(key, value);
	}



	public boolean expire(String key,int expireSeconds) throws Exception{
		return stringRedisTemplate.expire(key,expireSeconds, TimeUnit.SECONDS);
	}

}
