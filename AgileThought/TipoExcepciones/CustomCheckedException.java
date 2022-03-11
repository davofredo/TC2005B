public class CustomCheckedException {
    public static void main(String[] args) throws MyCustumCheckedException{
        getCustomerById(1);
    }

    public static void getCustomerById(int id) throws MyCustomCheckedException {
        if (id == 0) {
            throw new MyCustomCheckedException("El id no puede ser 0");
        }
    }
}
