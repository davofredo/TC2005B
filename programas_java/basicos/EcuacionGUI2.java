import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EcuacionGUI2 extends JFrame implements ActionListener
{
	// Atributos
	private JTextField tfCoeficienteA, tfCoeficienteB, tfCoeficienteC;
	private JButton bCalcular, bSalir;

	// Constructor
	public EcuacionGUI2()
	{
		// 1. Poner titulo al JFrame
		setTitle("Ecuacion Cuadratica");

		// 2. Crear los objetos de los atributos
		tfCoeficienteA = new JTextField();
		tfCoeficienteB = new JTextField();
		tfCoeficienteC = new JTextField();
		bCalcular = new JButton("Calcular Raices");
		bSalir = new JButton("Exit");

		// Actividad 2.5 Adicionar addActionListener a los JButtons
		bCalcular.addActionListener(this);
		bSalir.addActionListener(this);

		// 3. Crear el layout para los objetos
		setLayout(new GridLayout(4, 2));

		// 4. Colocar los objetosen JFrame
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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void calcularRaices(int a, int b, int c)
	{
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

	public void actionPerformed(ActionEvent event)
	{
		int a, b, c;

		if(event.getSource() == bCalcular){
			try{
				// 1. Obtener coeficientes de los JTextField
				a = Integer.parseInt(tfCoeficienteA.getText());
				b = Integer.parseInt(tfCoeficienteB.getText());
				c = Integer.parseInt(tfCoeficienteC.getText());


				// 2. Calcular Raices
				calcularRaices(a, b, c);
			}
			catch(NumberFormatException nfe){
				System.out.println("Error " + nfe);
			}
		}
			
		if(event.getSource() == bSalir)
			System.exit(0);
	}

	public static void main(String args[])
	{
		EcuacionGUI2 ecuacion = new EcuacionGUI2();
		//EcuacionGUI2 ecuacion = new EcuacionGUI2("Constructor 2");
	}
}