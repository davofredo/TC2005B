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

public class GradosGUI extends JFrame implements ActionListener
{
	// Atributos
	private JTextField tfGradosConvertir;
	private JButton bFarenhait, bCelcius;

	// Constructor
	public GradosGUI()
	{
		// Titulo al Frmae
		setTitle("Conversion de Grados");

		// Crear objeots de los atributos
		tfGradosConvertir = new JTextField();
		bFarenhait = new JButton("G. Celcius a G. Farenhait");
		bCelcius = new JButton("G. Farenhait a G. Celcius");

		// Crear layout
		setLayout(new GridLayout(2,2));

		// Objetos en Frame
		add(new JLabel("Grados a convertir"));
		add(tfGradosConvertir);
		add(bFarenhait);
		add(bCelcius);

		// Hacer visible al Frame
		setSize(400, 200);
		setVisible(true);
	}

	private void celciusFarenhait(int c){
		double f = (9/5)*c + 32;
		String str = String.format("%f", f);
		tfGradosConvertir.setText(str);
	}

	private void farenhaitCelcius(int f){
		double c = (float)(f - 32 ) / 1.8;
		String str = String.format("%f", c);
		tfGradosConvertir.setText(str);
	}

	public void actionPerformed(ActionEvent event)
	{
		int v;

		// Convertir
		if(event.getSource() == bFarenhait){
			v = Integer.parseInt(tfGradosConvertir.getText());

			celciusFarenhait(v);
		}
		if(event.getSource() == bCelcius){
			v = Integer.parseInt(tfGradosConvertir.getText());
			farenhaitCelcius(v);
		}
	}

	// main
	public static void main(String args[])
	{
		GradosGUI grados = new GradosGUI();
	}
}