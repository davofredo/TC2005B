import javax.swing.*;

import java.awt.*;

public class EcuacionGUI extends JFrame
{
	// Atributos
	private JTextField tfCoeficienteA, tfCoeficienteB, tfCoeficienteC;
	private JButton bCalcular, bSalir;

	// Constructor
	public EcuacionGUI()
	{
		// 1. Poner titulo al JFrame
		setTitle("Ecuacion Cuadratica");

		// 2. Crear los objetos de los atributos
		tfCoeficienteA = new JTextField();
		tfCoeficienteB = new JTextField();
		tfCoeficienteC = new JTextField();
		bCalcular = new JButton("Calcular Raices");
		bSalir = new JButton("Exit");

		// 3. Crear el layout para los objetos
		setLayout(new GridLayout(4, 2));

		// 4. Colocar los objetos en JFrame
		add(new JLabel("Coeficiente A = "));
		add(tfCoeficienteA);
		add(new JLabel("Coeficiente B = "));
		add(tfCoeficienteB);
		add(new JLabel("Coeficiente C = "));
		add(tfCoeficienteC);
		add(bCalcular);
		add(bSalir);

		// 5. Hacer visible el JFrame
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String args[])
	{
		EcuacionGUI ecuacion = new EcuacionGUI();
		//EcuacionGUI ecuacion = new EcuacionGUI("Constructor 2");
	}
}