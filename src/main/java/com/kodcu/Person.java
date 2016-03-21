package com.kodcu;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

/**
 * Created by usta on 19.02.2015.
 */
public class Person {

    @FormParam("name")
    @NotNull
    @Size(min = 2)
    private String name;

    @FormParam("surname")
    @NotNull
    @Size(min = 2)
    private String surname;

    @FormParam("age")
    @Min(0)
    @NotNull
    private Integer age;

    public Person() {
    }

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
