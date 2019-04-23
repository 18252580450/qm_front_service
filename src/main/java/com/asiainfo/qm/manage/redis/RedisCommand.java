package com.asiainfo.qm.manage.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@Service
public class RedisCommand {


    @Value("${redis.key.perfix}")
    private String redisKeyPerfix;
	@Autowired
	StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;



	public String get(String key) throws Exception {
        key = redisKeyPerfix + key;
        return stringRedisTemplate.opsForValue().get(key);
    }

	public void set(String key,String value,int expireSeconds) throws Exception{
        key = redisKeyPerfix + key;
		stringRedisTemplate.opsForValue().set(key, value, expireSeconds, TimeUnit.SECONDS);
	}

	public void set(String key,String value) throws Exception{
        key = redisKeyPerfix + key;
		stringRedisTemplate.opsForValue().set(key, value);
	}

    public void hashPutAll(String key, Map value) throws Exception {
        key = redisKeyPerfix + key;
        redisTemplate.opsForHash().putAll(key, value);
    }

    public void hashPut(String key, String hashKey, Map value) throws Exception {
        key = redisKeyPerfix + key;
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    public Object hashGet(String key, String value) throws Exception {
        key = redisKeyPerfix + key;
        return redisTemplate.opsForHash().get(key, value);
    }

	public boolean expire(String key,int expireSeconds) throws Exception{
        key = redisKeyPerfix + key;
		return stringRedisTemplate.expire(key,expireSeconds, TimeUnit.SECONDS);
	}

    //获取符合匹配规则的所有key
    public Set<String> getAllKeys(String patten) {
        patten = redisKeyPerfix + patten;
        Set<String> keys = stringRedisTemplate.keys(patten);
        return keys;
    }

    //删除缓存
    public void delete(Set<String> keys) throws Exception {
        Set<String> redisKeySet = new HashSet<>();
        for (String key : keys) {
            redisKeySet.add(redisKeyPerfix + key);
        }
        stringRedisTemplate.delete(redisKeySet);
    }

}
