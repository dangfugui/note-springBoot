package com.dang.note.springboot.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    //id属性是给mongodb用的，用@Id注解修饰
    @Id
    private String id;
    private String name;
    private Integer age;


    public Person() {
        super();
    }

    public Person(String id, String name, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}