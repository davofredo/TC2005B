package math;

import input.Input;
import input.InputAbortedException;

public class Hipotenuse {
    public static void main(String[] args) {
        try {
            Input input = new Input();
            double hick1 = input.readDouble("Hick 1", false);
            double hick2 = input.readDouble("Hick 2", false);
            double hypotenuse = Math.sqrt(Math.pow(hick1, 2) + Math.pow(hick2, 2));

            System.out.printf("The hypotenuse is  %s%n", hypotenuse);
        } catch (InputAbortedException e) {
            System.err.println(e.getMessage());
        }
    }
}
