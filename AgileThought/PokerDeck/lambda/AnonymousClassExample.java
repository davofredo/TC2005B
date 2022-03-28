package com.at.internship.lambda;

import java.util.List;

public class AnonymousClassExample {

    public static void main(String[] args) {
        List<Person> people = PeopleHelper.getPeople();
        PeopleHelper.printPeople(people, new ICheckPerson() {
            @Override
            public boolean test(Person p) {
                return Person.GENDER_MALE.equals(p.getGender())
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        });
    }

}

