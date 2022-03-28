package com.at.internship.lambda;

import java.util.List;

public class LambdaExpressionExample {

    public static void main(String[] args) {

        List<Person> people = PeopleHelper.getPeople();

        // Using printPeople + lambda expression for ICheckPerson
        PeopleHelper.printPeople(people, p -> Person.GENDER_MALE.equals(p.getGender())
                && p.getAge() >= 18
                && p.getAge() <= 25);

        // Using aggregate operations (no need for printPeople or ICheckPerson anymore)
        people
                .stream()
                .filter(p -> Person.GENDER_MALE.equals(p.getGender())
                        && p.getAge() >= 18
                        && p.getAge() <= 25)
                .forEach(p -> p.printPerson());
    }

}
