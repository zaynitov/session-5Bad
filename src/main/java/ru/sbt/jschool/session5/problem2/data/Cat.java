package ru.sbt.jschool.session5.problem2.data;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author NIzhikov
 */
@JsonPropertyOrder({ "age", "name" })

public class Cat extends Animal {
    public int age;

    public Cat(String name) {
        super(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
