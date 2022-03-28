package com.at.internship.lambda;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    static final String GENDER_MALE = "MALE";
    static final String GENDER_FEMALE = "FEMALE";

    String name;
    LocalDate birthday;
    String gender;
    String emailAddress;

    public Person(String name, LocalDate birthday, String gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public void printPerson() {
        System.out.printf("[PERSON] " +
                        "{ \"name\":\"%s\", \"birthday\":\"%s\", \"gender\":\"%s\", \"emailAddress\":\"%s\" }%n",
                name, birthday, gender, emailAddress);
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
