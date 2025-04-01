package vista;

//Esta clase crea la ventana principal la cual contiene el panel principal

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class FrameJuego extends JFrame implements ActionListener {

    private PanelPrincipal juego;
    final JButton reset;

    final JLabel imagen;
    final ImageIcon portada = new ImageIcon(getClass().getResource("/imagenes/monty.jpg"));

    // Constructor de la clase FrameJuego
    public FrameJuego() {
        setVisible(true);
        setLayout(null);
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Monty Hall");
        getContentPane().setBackground(Color.WHITE);

        // Creación y configuración del botón de reinicio
        reset = new JButton("Iniciar");
        reset.setBounds(20, 10, 80, 20);
        reset.addActionListener(this);
        add(reset);

        // Creación y configuración de la imagen de portada
        imagen = new JLabel("");
        imagen.setBounds(100, 60, 800, 500);
        imagen.setIcon(portada);
        add(imagen);

        // Creación del panel principal del juego
        juego = new PanelPrincipal();
        this.add(juego);
        setLocationRelativeTo(null);
    }

    // Manejo del evento de acción
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(reset.getActionCommand())) {
            this.remove(juego);
            juego = new PanelPrincipal();
            this.add(juego);
            SwingUtilities.updateComponentTreeUI(this);

            imagen.setVisible(false);
        }
    }
}
