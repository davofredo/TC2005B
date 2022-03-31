import java.util.ArrayList;
import java.util.List;

public class WildcardsDemo {

    public static void printObjectList(List<Object> list) {
        list.forEach(e -> System.out.print(e +" , "));
        System.out.println();
    }

    public static void printObjectListV2(List<?> list) {
        list.forEach(e -> System.out.print(e +" , "));
        System.out.println();
    }

    public static Number sum(List<Number> nums) {
        double acumulador = 0;
        for (Number num : nums)
            acumulador += num.doubleValue();
        return acumulador;
    }

    public static Number sum2(List<? extends Number> nums) {
        double acumulador = 0;
        for (Number num : nums)
            acumulador += num.doubleValue();
        return acumulador;
    }

    public static void main(String[] args) {
        List<Object> objList = new ArrayList<>();
        objList.add("Texto");
        objList.add(1);
        objList.add(1.0);
        objList.add(false);
        objList.add(objList);

        List<String> strList = new ArrayList<>();
        strList.add("Text2");
        strList.add("Text3");
        // List<Object> and List<String> are not the same and not interchangeable
        // prointObjectList(strList);

        /****************************
         * Wildcard <?>
         ****************************/
        printObjectListV2(objList);
        printObjectListV2(strList);

        /****************************
         * <? extends>
         ****************************/

        List<Number> numList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        Number num1 = 1.0;
        Integer int1 = 1;

        // intList.add(num1);
        intList.add(int1);
        intList.add(2);
        // num1 is a Number so it can be added into numList
        numList.add(num1);
        // int1 extends Number so it can be added into numList
        numList.add(int1);

        Number sum1 = sum(numList);
        System.out.println("Sum1: " + sum1);
        // List<Number> and List<Integer> are not the same and not interchangeable as they are different 
        //Number sum2 = sum(intList);

        Number sum3 = sum2(numList);
        System.out.println("Sum3: " + sum3);

        Number sum4 = sum2(intList);
        System.out.println("Sum3: " + sum4);

        // List<String> does not extend from List<? extends Number>
        // sum2(strList);

        /***
         * Editing lists if ? type
         ***/

        List<?> anyTypeList = objList;
        // anyTypeList.add("Text");

        List<? extends Number> anyNumberList = intList;
        // anyNumberList.add(num1);
        // anyNumberList.add(int1);
    }
}
