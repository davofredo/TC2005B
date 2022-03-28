package math;

import java.math.BigDecimal;

import input.Input;
import input.InputAbortedException;

public class CompoundInterest {
    public static void main(String[] args) {
        // Migrar usando las clases de Math
        try {
            Input input = new Input();
            // c = capital inicial
            double c = input.readDouble("Provide initial capital", false);
            // i = interes
            //double i = input.readDouble("Provide interest rate", false);
            BigDecimal i = new BigDecimal(input.readDouble("Provide interest rate", false));
            // t = tiempo en años
            int t = input.readInt("Provide time (in years)", false);
            double finalCapital = Math.round(c * Math.pow(1 + i.doubleValue(), t)*100)/100.00;
            System.out.printf("After %s years your capital will increase to $ %s%n", t, finalCapital);
        } catch (InputAbortedException e) {
            System.err.println(e.getMessage());
        }
    }
}
