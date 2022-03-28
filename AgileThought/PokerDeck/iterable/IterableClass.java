package com.at.internship.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableClass implements Iterable<String> {

    public static void main(String[] args) {
        IterableClass iterableObject = new IterableClass();
        for(String value : iterableObject) {
            System.out.println(value);
        }
    }

    @Override
    public Iterator<String> iterator() {
        final String[] values = {"val1", "val2", "val3"};
        return new Iterator<>() {
            int nextIndex = 0;
            @Override
            public boolean hasNext() {
                return nextIndex < values.length;
            }

            @Override
            public String next() {
                if(hasNext())
                    return values[nextIndex++];
                throw new NoSuchElementException("No more elements left");
            }
        };
    }

}
