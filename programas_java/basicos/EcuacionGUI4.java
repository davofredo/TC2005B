import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EcuacionGUI4 extends JFrame implements ActionListener
{
	// Atributos
	private JTextField tfCoeficienteA, tfCoeficienteB, tfCoeficienteC;
	private JButton bCalcular, bSalir;
	private JTextArea taDatos;
	private JPanel panel1, panel2;

	private CalculoDP calculo = new CalculoDP();

	// Constructor
	public EcuacionGUI4()
	{
		// 1. Poner titulo al JFrame
		setTitle("Ecuacion Cuadratica");

		// 2. Crear los objetos de los atributos
		tfCoeficienteA = new JTextField();
		tfCoeficienteB = new JTextField();
		tfCoeficienteC = new JTextField();
		bCalcular = new JButton("Calcular Raices");
		bSalir = new JButton("Exit");
		taDatos = new JTextArea(10,20);
		panel1 = new JPanel();
		panel2 = new JPanel();

		// Actividad 2.5 Adicionar addActionListener a los JButtons
		bCalcular.addActionListener(this);
		bSalir.addActionListener(this);

		// 3. Crear el layout para los JPanels
		panel1.setLayout(new GridLayout(4, 2));
		panel2.setLayout(new FlowLayout());

		// 4. Colocar los objetos en JPanel correspondiente
		panel1.add(new JLabel("Coeficiente A = "));
		panel1.add(tfCoeficienteA);
		panel1.add(new JLabel("Coeficiente B = "));
		panel1.add(tfCoeficienteB);
		panel1.add(new JLabel("Coeficiente C = "));
		panel1.add(tfCoeficienteC);
		panel1.add(bCalcular);
		panel1.add(bSalir);

		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));

		// 5. Adicionar panel2 al JFrame y hacerlo visible
		add(panel2);
		setSize(500, 400);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent event)
	{
		int a, b, c;
		String resultado;

		if(event.getSource() == bCalcular){
			try{
				// 1. Obtener coeficientes de los JTextField
				a = Integer.parseInt(tfCoeficienteA.getText());
				b = Integer.parseInt(tfCoeficienteB.getText());
				c = Integer.parseInt(tfCoeficienteC.getText());


				// 2. Calcular Raices
				resultado = calculo.calcularRaices(a, b, c);

				// 3. Desplegar Resultados
				taDatos.setText(resultado);
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
		EcuacionGUI4 ecuacion = new EcuacionGUI4();
		//EcuacionGUI2 ecuacion = new EcuacionGUI2("Constructor 2");
	}
}