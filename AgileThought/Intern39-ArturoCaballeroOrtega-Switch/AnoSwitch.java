public class AnoSwitch {
    public static void main(String[] args) {
        byte valor = 0;

        valor = Byte.parseByte(System.console().readLine("Ingrese un numero de mes del 1 al 12"));

        switch (valor) {
            case 1:
                System.out.println("Enero: 31 dias");
                break;
                case 2:
                boolean bi = Boolean.parseBoolean(System.console().readLine("El ano es bisiesto: true/false "));
                if(bi)
                    System.out.println("Febrero: 29 dias");
                else
                    System.out.println("Febrero: 28 dias");
                break;
                case 3:
                System.out.println("Marzo: 31 dias");
                break;
                case 4:
                System.out.println("Abril: 30 dias");
                break;
                case 5:
                System.out.println("Mayo: 31 dias");
                break;
                case 6:
                System.out.println("Junio: 30 dias");
                break;
                case 7:
                System.out.println("Julio: 31 dias");
                break;
                case 8:
                System.out.println("Agosto: 31 dias");
                break;
                case 9:
                System.out.println("Septiembre: 30 dias");
                break;
                case 10:
                System.out.println("Octubre: 31 dias");
                break;
                case 11:
                System.out.println("Noviembre: 30 dias");
                break;
                case 12:
                System.out.println("Diciembre: 31 dias");
                break;
            default:
                break;
        }
    }
}
