import javax.swing.JOptionPane;

public class Suma
{
	public static void main(String args[])
	{
		//1. Obtener los valores de A y B
		int a = Integer.parseInt(JOptionPane.showInputDialog("Ingr	ese el valor de A: "));
		int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de B: "));
		//2. Sumar C = A + B
		int c = a + b;
		//3. Desplegar resultado de la suma
		JOptionPane.showMessageDialog(null, "El resultado de la Suma A + C ");
		JOptionPane.showMessageDialog(null, "El resultado es " + c);
	}
}