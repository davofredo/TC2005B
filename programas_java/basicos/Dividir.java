import javax.swing.JOptionPane;

public class Dividir
{
	public static void main(String args[])
	{
		//1. Obtener los valores de A y B
		float a = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de A: "));
		float b = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de B: "));

		//2. Dividir C = A / B
		float c = a / b;
		a = (int)a;			   // Otra forma de convertir a float
		float c1 = (float)a/b; //

		//3. Desplegar resultado de la suma
		JOptionPane.showMessageDialog(null, "El resultado de la Division A / C es = " + c);
		//JOptionPane.showMessageDialog(null, "El resultado es " + c);
	}
}