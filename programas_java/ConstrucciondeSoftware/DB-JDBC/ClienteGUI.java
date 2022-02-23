import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteGUI extends JFrame implements ActionListener
{
	//Atributos
	private JTextField tfNcta, tfNombre, tfTipo, tfSaldo;
	private JButton bCapturar, bConsultar, bConsultarNcta, bConsultarTipo, bSalir;
	private JTextArea taDatos;
	private JPanel panel1, panel2;

	//private BancoAD banco = new BancoAD();
	private BancoADjdbc banco = new BancoADjdbc();

	public ClienteGUI(){
		// Poner el titulo del JFrame
		setTitle("Banco WEB-OOP");

		// Crear los objetos de los atributos
		tfNcta = new JTextField();
		tfNombre = new JTextField();
		tfTipo = new JTextField();
		tfSaldo = new JTextField();
		bCapturar = new JButton("Capturar Cliente");
		bConsultar = new JButton("Consultar Cliente");
		bConsultarNcta = new JButton("Consultar No. de Cuenta");
		bConsultarTipo = new JButton("Consultar tipo");
		bSalir = new JButton("Exit");
		taDatos = new JTextArea(10, 20);
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		// add ActionListener
		bCapturar.addActionListener(this);
		bConsultar.addActionListener(this);
		bConsultarNcta.addActionListener(this);
		bConsultarTipo.addActionListener(this);
		bSalir.addActionListener(this);

		// Definir los Layouts de los JFrame
		panel1.setLayout(new GridLayout(7, 2));
		panel2.setLayout(new FlowLayout());

		// Colocar los atributos en los JPanel correspondientes
		panel1.add(new JLabel("No. de Cuenta: "));
		panel1.add(tfNcta);
		panel1.add(new JLabel("Nombre: "));
		panel1.add(tfNombre);
		panel1.add(new JLabel("Tipo de Cuenta:"));
		panel1.add(tfTipo);
		panel1.add(new JLabel("Saldo: "));
		panel1.add(tfSaldo);
		panel1.add(bCapturar);
		panel1.add(bConsultar);
		panel1.add(bConsultarNcta);
		panel1.add(bConsultarTipo);
		panel1.add(bSalir);

		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));


		// Adicionar los JPanel al JFrame y hacerlo visible
		add(panel2);
		setSize(400, 400);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private String obtenerDatos()
	{
		String datos = "", ncta, nombre, tipo, saldo;

		ncta = tfNcta.getText();
		nombre = tfNombre.getText();
		tipo = tfTipo.getText();
		saldo = tfSaldo.getText();

		if(ncta.equals("") || nombre.isEmpty() || tipo.isEmpty() || saldo.equals(""))
			datos = "VACIO";
		else{
			try{
				int cantidad = Integer.parseInt(saldo);
				datos = ncta + "_" + nombre + "_" + tipo + "_" + saldo;
				}
			catch(NumberFormatException nfe){
				datos = "NO_NUMERICO";
				System.out.println("Error: " + nfe);
			}
		}

		return datos;
	}

	public void actionPerformed(ActionEvent event)
	{
		String respuesta = "", datos;
		if(event.getSource() == bCapturar){

			// Obtener los datos de los JTextFields
			datos = obtenerDatos();
			if(datos.equals("VACIO"))
				respuesta = "Algun campo está vacio...";
			else{
				if(datos.equals("NO_NUMERICO"))
					respuesta = "El saldo debe ser numerico...";
				else{
					// Capturar datos
					respuesta = banco.capturar(datos);
					}
			}

			// Mostrar el resultado de la transaccion
			taDatos.setText(respuesta);
		}
		if(event.getSource() == bConsultar)
		{
			// Consultar datos del archivo
			datos = banco.consultar();

			//Mostrar los datos
			taDatos.setText(datos);
		}

		if(event.getSource() == bConsultarNcta)
		{
			// Obtener el tipo de cuenta a consultar
			String ncta =tfNcta.getText();

			// Consultar cliente con ese tipo de cuenta
			datos = banco.consultarNcta(ncta);

			// Mostrar los datos
			taDatos.setText(datos);
		}

		if(event.getSource() == bConsultarTipo)
		{
			// Obtener el tipo de cuenta a consultar
			String tcta =tfTipo.getText();

			// Consultar cliente con ese tipo de cuenta
			datos = banco.consultarTipo(tcta);

			// Mostrar los datos
			taDatos.setText(datos);
		}

		if(event.getSource() == bSalir)
			System.exit(0);
	}

	public static void main(String args[]){
		ClienteGUI cliente = new ClienteGUI();
	}
}