import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AudioGUI3 extends JFrame implements ActionListener
{
    // Atributos, caracteristicas o propiedades de la class. Variables de clase o variables de instancia
    private JTextField tfSong;
    private JButton    bPlay, bStop;
    
    private Audio2 audio = new Audio2();

    // Constructor
    public AudioGUI3()
    {
        setTitle("Audio Player");
        
        // 1. Incicializar o crear los objetos de las variables de clase o atributos
        tfSong = new JTextField(15);
        bPlay  = new JButton("Play");
        bStop  = new JButton("Stop");
        
        // 1.5 Colocar la deteccion de eventos a los JButtons
        bPlay.addActionListener(this);
        bStop.addActionListener(this);
        
        // 2. Crear el Layout de arreglo de objetos
        //setLayout(new GridLayout(2,2));
        setLayout(new FlowLayout());
        
        // 3. Colocar los objetos de los atributos en el Layout del JFrame
        add(new JLabel("SONG: "));
        add(tfSong);
        add(bPlay);
        add(bStop);
        
        // 4. Hacer visible el JFrame
        setSize(300,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getSource() == bPlay)
        {
            //JOptionPane.showMessageDialog(null,"Play song...");
            // 1. Obtener la cancion del TextField correspondiente
            String song = tfSong.getText();

            // 2. Reproducir la cancion
            audio.reproducir(song+".mp3");
        }
        
        if(evento.getSource() == bStop)
        {
            //JOptionPane.showMessageDialog(null,"Stop song...");
            audio.stopSong();
        }
    }
    
    public static void main(String args[])
    {
        AudioGUI3 audioGUI = new AudioGUI3();
    }
}

