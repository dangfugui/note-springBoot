package com.dang.note.springboot.resource.mongodb;

import com.dang.note.springboot.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by dangqihe on 2017/7/14.
 */
public interface PersonRepository extends MongoRepository<Person,String> {
    public List<Person> findByName(String name);
}
