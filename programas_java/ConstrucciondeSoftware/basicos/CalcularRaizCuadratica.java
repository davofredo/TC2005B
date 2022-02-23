import javax.swing.JOptionPane;

public class CalcularRaizCuadratica
{
	public static void main(String args[])
	{
		//1. Obtener los valores de A, B y C
		int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de A: "));
		int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de B: "));
		int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de C: "));

		// Condicionar si A es o no 0
		if(a == 0){ // Si A es 0
			// Condicionar si B es o no 0
			if(b == 0){ // Si B es 0
				JOptionPane.showMessageDialog(null, "Error no hay coeficientes");
			}
			else{ // Si B no es 0
				float x = -(float)c/b;
				JOptionPane.showMessageDialog(null, "Ecuacion lineal X = " + x);
			}
		}
		else{
			int i = (b*b) - (4*a*c);
			if(i < 0){
				JOptionPane.showMessageDialog(null, "Raices imaginarias");
			}
			else{
				double x1 = (-b+Math.sqrt(i)) / (2*a);
				double x2 = (-b-Math.sqrt(i)) / (2*a);
				JOptionPane.showMessageDialog(null, "Ecuacion cuadratica\nX1 = " + x1 + "\nX2 = " + x2);
			}
		}
	}
}