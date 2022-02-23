public class CalculoDP
{
	public String calcularRaices(int a, int b, int c)
	{
		String resultado;
		//return "Raices para los coeficientes: A= " + a + " B= " + b + " C= " + c;

		// Condicionar si A es o no 0
		if(a == 0){ // Si A es 0
			// Condicionar si B es o no 0
			if(b == 0){ // Si B es 0
				return "Error, no hay coeficientes\n";
			}
			else{ // Si B no es 0
				float x = -(float)c/b;
				//JOptionPane.showMessageDialog(null, "Ecuacion lineal X = " + x);
				return "Ecuacion lineal X = " + x + "\n";
			}
		}
		else{
			int i = (b*b) - (4*a*c);
			if(i < 0){
				//JOptionPane.showMessageDialog(null, "Raices imaginarias");
				return "Raices Imaginarias...\n";
			}
			else{
				double x1 = (-b+Math.sqrt(i)) / (2*a);
				double x2 = (-b-Math.sqrt(i)) / (2*a);
				//JOptionPane.showMessageDialog(null, "Ecuacion cuadratica\nX1 = " + x1 + "\nX2 = " + x2);
				return "Ecuacion cuadratica\nX1 = " + x1 + "\nX2 = " + x2 + "\n";
			}
		}
	}
}