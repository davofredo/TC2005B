package math;

import java.math.BigDecimal;
import java.math.RoundingMode;

import input.Input;
import input.InputAbortedException;

public class CashRegister {
    public static void main(String[] args) {
        Input input = new Input();
        BigDecimal total = BigDecimal.ZERO;
        int index = 1;
        System.out.println("Enter prices on per line(Enter \"--\" when finished):");

        boolean keepReading = true;
        while (keepReading) {
            try {
                total = total.add(new BigDecimal(input.readDouble("Price " + index))).setScale(2, RoundingMode.HALF_UP);
                index++;
            } catch (InputAbortedException e) {
                keepReading = false;
            }
            new BigDecimal(8.0);
        }

        System.out.println("Total amount: " + total);

        try {
            BigDecimal payment = new BigDecimal(input.readDouble("Enter payment")).setScale(2, RoundingMode.HALF_UP);
            BigDecimal change = payment.subtract(total);
            if (change.compareTo(BigDecimal.ZERO) < 0)
                System.out.printf("You need to pay $%s more", change.abs());
            else if (change.compareTo(BigDecimal.ZERO) == 0)
                System.out.println("You have no change");
            else
                System.out.printf("You recive $%s in change", change);
        } catch (InputAbortedException e) {
            System.out.println("Salle cancelled");
        }
    }
}
