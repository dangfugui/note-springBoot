package com.dang.note.springboot.resource.mysql;

import com.dang.note.springboot.domain.Person;

import java.util.List;

/**
 * Created by dangqihe on 2017/7/14.
 */
public interface PersonMapper {
    List<Person> list();
}