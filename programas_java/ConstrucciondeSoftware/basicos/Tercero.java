import javax.swing.JOptionPane;

public class Tercero
{
	public static void main(String args[])
	{
		String nombre = JOptionPane.showInputDialog("BIENVENIDO AL PROGRAMA, CUAL ES TU NOMBRE: ");
		System.out.println("Hola " + nombre + " buenos dias...");
		JOptionPane.showMessageDialog(null, "Hola " + nombre + " buenos dias...");
	}
}