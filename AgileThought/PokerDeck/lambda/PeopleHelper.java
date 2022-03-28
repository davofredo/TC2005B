package com.at.internship.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PeopleHelper {

    public static void printPeople(List<Person> roster, ICheckPerson tester) {
        for(Person p : roster) {
            if(tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person(
                "Emma",
                LocalDate.of(2002, 2, 16),
                Person.GENDER_FEMALE,
                "emma123@fakedomain.com"));
        people.add(new Person(
                "Jorge",
                LocalDate.of(2001, 5, 5),
                Person.GENDER_MALE,
                "jorge123@fakedomain.com"));
        people.add(new Person(
                "Pedro",
                LocalDate.of(1990, 9, 14),
                Person.GENDER_MALE,
                "pedro123@fakedomain.com"));
        people.add(new Person(
                "Gonzalo",
                LocalDate.of(2010, 11, 1),
                Person.GENDER_MALE,
                "emma123@fakedomain.com"));
        return people;
    }

}
