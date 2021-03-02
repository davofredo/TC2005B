import javax.swing.JOptionPane;

public class EcuacionM2
{
	public static int obtenerValor(char c)
	{
		int valor = -100;
		boolean numeroCorrecto = false;

		do
		{
			try{
				valor = Integer.parseInt(JOptionPane.showInputDialog("Coeficiente " + c + ": "));
				numeroCorrecto = true;
			}
			catch(NumberFormatException nfe){
				System.out.println("Error: Los coeficientes deben ser números enteros...\n" + nfe);
			}
		}while(!numeroCorrecto);
		return valor;
	}

	public static void calcularRaices(int a, int b, int c){
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

	public static void main(String args[])
	{
		int a, b, c;
		// 1. Obtener los coeficientes de la ecuaacion
		a = obtenerValor('A');
		b = obtenerValor('B');
		c = obtenerValor('C');

		System.out.println("A = " + a + "\nB = " + b + "\nC = " + c);

		// 2. Obtener las raices y desplegarlas
		calcularRaices(a, b, c);
	}
}