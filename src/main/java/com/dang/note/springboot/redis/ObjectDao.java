package com.dang.note.springboot.redis;

import javax.annotation.Resource;

import com.dang.note.springboot.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class ObjectDao<KEY,VALUE> {
    @Autowired
    RedisTemplate<KEY,VALUE> redisTemplate;
    @Resource(name="redisTemplate")
    ValueOperations<KEY,VALUE> valOps;
    public void save(KEY key,VALUE value){
        valOps.set(key, value);
    }
    public Person get(KEY key){
        return (Person) valOps.get(key);
    }
}