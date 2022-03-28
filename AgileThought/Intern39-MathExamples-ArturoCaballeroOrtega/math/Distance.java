package math;

import java.awt.Point;

import input.AdvancedInput;

public class Distance {
    public static void main(String[] args) {
        AdvancedInput input = new AdvancedInput();
        Point point1 = input.readPoint("Point 1");
        Point point2 = input.readPoint("Point 2");

        // Calcular distancia
        // double distance
        //double distancia = Math.sqrt(Math.pow(point2.x-point1.x,2) + Math.pow(point2.y-point1.y, 2));

        /*double h1 = point2.y - point1.y;
        double h2 = point2.x - point1.x;
        double distancia = Math.hypot(h2, h1);*/

        double distancia = point1.distance(point2);

        System.out.printf("The distance is %s%n", distancia);
    }
}
