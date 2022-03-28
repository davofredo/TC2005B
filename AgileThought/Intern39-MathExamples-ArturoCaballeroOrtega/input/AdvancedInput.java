package input;

import java.awt.*;

public class AdvancedInput extends Input {

    public Point readPoint(String prompt) {
        while (true) {
            try {
                String coordinates = readLineUnhandled(prompt);
                String[] coordinateArray = coordinates.split(",");
                if(coordinateArray.length != 2)
                    throw new IllegalArgumentException("Invalid point definition");
                return new Point(Integer.parseInt(coordinateArray[0]), Integer.parseInt(coordinateArray[1]));
            } catch (IllegalArgumentException e) {
                System.err.println("Provide a point in format: x,y. Example: 4,7");
            }
        }
    }

}
