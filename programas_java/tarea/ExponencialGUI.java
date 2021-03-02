import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExponencialGUI extends JFrame implements ActionListener
{
    // Crear atributos
    private JTextField tfBase, tfExponente;
    private JButton bExponente, bSalir;

    // Constructor
    public ExponencialGUI()
    {
        // Titulo al Frame
        setTitle("Calculo de exponencial");

        // Crear los objetos de los atributos
        tfBase = new JTextField();
        tfExponente = new JTextField();
        bExponente = new JButton("Y = B ^ X");
        bSalir = new JButton("Salir");

        // Crear el Listener
        bExponente.addActionListener(this);
        bSalir.addActionListener(this);

        // Crear el layout
        setLayout(new GridLayout(3, 2));

        // Colocar los Objetos
        add(new JLabel("Base = "));
        add(tfBase);
        add(new JLabel("X = "));
        add(tfExponente);
        add(bExponente);
        add(bSalir);

        // Hacer visible el JFrame
        setSize(300, 300);
        setVisible(true);
    }

    private void calcularExponente(int x, int n){
        double res = Math.pow(x, n);

        JOptionPane.showMessageDialog(null, "Y = " + res);
    }

    public void actionPerformed(ActionEvent event)
    {
        int v1, v2;
        if(event.getSource() == bExponente){
            v1 = Integer.parseInt(tfBase.getText());
            v2 = Integer.parseInt(tfExponente.getText());

            calcularExponente(v1, v2);
        }
        if(event.getSource() == bSalir)
            System.exit(0);
    }

    public static void main(String args[]){
        ExponencialGUI exponencial = new ExponencialGUI();
    }
}