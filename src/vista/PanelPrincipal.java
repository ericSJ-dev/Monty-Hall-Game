package vista;

//Esta clase contiene todos los elementos graficos del juego

import controlador.Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel implements ActionListener{
    Control c = new Control();

    int puertaFalsa;
    int puertaGanadora;
    boolean resultado;
    
    //imagenes de las puertas para el juego
    
    final JLabel imagen1;
    final JLabel imagen2;
    final JLabel imagen3;
    
    //recuadros para cada eleccion
    
    final JLabel eleccion1;
    final JLabel eleccion2;
    
    //recuerdo para mostrar la imagen del premio y de la informacion del juego
    
    final JLabel informacion;
    final JLabel premio;
    
    //cajas checkbox para realizar la eleccion
    
    //para la primera eleccion
    
    final JCheckBox primeraEleccion1;
    final JCheckBox primeraEleccion2;
    final JCheckBox primeraEleccion3;
    
    //para la segunda eleccion
    
    final JCheckBox segundaEleccion1;
    final JCheckBox segundaEleccion2;
    final JCheckBox segundaEleccion3;
    
    //botones en el recuadro de la primera eleccion para elegir o quitar la eleccion
    
    final JButton primeraEleccion;
    final JButton quitarPrimeraEleccion;
    
    //botones en el recuadro de la segunda eleccion para elegir o quitar la eleccion
    final JButton segundaEleccion;
    final JButton quitarSegundaEleccion;
    
    //botones recuadro informacion
    final JButton jugar;
    final JButton simulacion;
    
    //textos de informacion para la simulacion
    final JLabel numJuegos;
    final JLabel cambio;
    final JLabel cambioPercent;
    final JLabel insiste;
    final JLabel insistePercent;
    
    //creacion de las imagenes puerta, carro y cabra almacenadas en un paquete llamado imagenes en el proyecto
    
    public ImageIcon puerta = new ImageIcon(getClass().getResource("/imagenes/puerta.JPG"));
    public ImageIcon carro = new ImageIcon(getClass().getResource("/imagenes/carro.JPG"));
    public ImageIcon cabra = new ImageIcon(getClass().getResource("/imagenes/cabra.JPG"));
    
    public PanelPrincipal(){
        setBounds(10,40,960,555);
        setLayout(null);
	setBorder(BorderFactory.createTitledBorder(""));
         
        //titulo, dimensiones, borde, insercion de imagen y creacion del label para las imagenes del juego
        
        imagen1 = new JLabel("");
	imagen1.setBounds(20, 10, 180, 260);
        imagen1.setBorder(BorderFactory.createTitledBorder("puerta 1"));
        imagen1.setIcon(puerta);
        add(imagen1);
        
        imagen2 = new JLabel("");
	imagen2.setBounds(220, 10, 180, 260);
        imagen2.setBorder(BorderFactory.createTitledBorder("Puerta 2"));
        imagen2.setIcon(puerta);
        add(imagen2);
        
        imagen3 = new JLabel("");
	imagen3.setBounds(420, 10, 180, 260);
        imagen3.setBorder(BorderFactory.createTitledBorder("Puerta 3"));
        imagen3.setIcon(puerta);
        add(imagen3);
        
        //recuadros de las elecciones
        
        eleccion1 = new JLabel("");
	eleccion1.setBounds(20, 300, 580, 100);
        eleccion1.setBorder(BorderFactory.createTitledBorder("Eleccion 1"));
        add(eleccion1);
        
        eleccion2 = new JLabel("");
	eleccion2.setBounds(20, 430, 580, 100);
        eleccion2.setBorder(BorderFactory.createTitledBorder("Eleccion 2"));
        add(eleccion2);
        
        //recuadro del apartado derecho de informacion y premio
        
        informacion = new JLabel("");
        informacion.setBounds(620, 10, 320,530);
        informacion.setBorder(BorderFactory.createTitledBorder("Tu premio"));
        add(informacion);
        
        premio = new JLabel("");
	premio.setBounds(690, 30, 180, 250);
        premio.setBorder(BorderFactory.createTitledBorder(""));
        premio.setIcon(puerta);
        add(premio);
        
        //chekbox
        
        primeraEleccion1 = new JCheckBox("Puerta 1");
        primeraEleccion1.setBounds(70,310,80,20);
        primeraEleccion1.addActionListener(this);
        primeraEleccion1.setEnabled(false);
        add(primeraEleccion1);
        
        primeraEleccion2 = new JCheckBox("Puerta 2");
        primeraEleccion2.setBounds(270,310,80,20);
        primeraEleccion2.addActionListener(this);
        primeraEleccion2.setEnabled(false);
        add(primeraEleccion2);
        
        primeraEleccion3 = new JCheckBox("Puerta 3");
        primeraEleccion3.setBounds(470,310,80,20);
        primeraEleccion3.addActionListener(this);
        primeraEleccion3.setEnabled(false);
        add(primeraEleccion3);
        
        segundaEleccion1 = new JCheckBox("Puerta 1");
        segundaEleccion1.setBounds(70,440,80,20);
        segundaEleccion1.addActionListener(this);
        segundaEleccion1.setEnabled(false);
        add(segundaEleccion1);
        
        segundaEleccion2 = new JCheckBox("Puerta 2");
        segundaEleccion2.setBounds(270,440,80,20);
        segundaEleccion2.addActionListener(this);
        segundaEleccion2.setEnabled(false);
        add(segundaEleccion2);
        
        segundaEleccion3 = new JCheckBox("Puerta 3");
        segundaEleccion3.setBounds(470,440,80,20);
        segundaEleccion3.addActionListener(this);
        segundaEleccion3.setEnabled(false);
        add(segundaEleccion3);
        
        //botones
                
        //botones de la primera eleccion
        
        primeraEleccion = new JButton("Elegir");
	primeraEleccion.setBounds(190,350,110,25);
	primeraEleccion.addActionListener(this);
        primeraEleccion.setEnabled(false);
        add(primeraEleccion);
        
        quitarPrimeraEleccion = new JButton("Quitar Eleccion");
	quitarPrimeraEleccion.setBounds(320,350,120,25);
	quitarPrimeraEleccion.addActionListener(this);
        quitarPrimeraEleccion.setEnabled(false);
        add(quitarPrimeraEleccion);
        
        //botones de la segunda eleccion
        
        segundaEleccion = new JButton("Elegir");
	segundaEleccion.setBounds(190,480,110,25);
	segundaEleccion.addActionListener(this);
        segundaEleccion.setEnabled(false);
	add(segundaEleccion);
        
        quitarSegundaEleccion = new JButton("Quitar Eleccion");
	quitarSegundaEleccion.setBounds(320,480,120,25);
	quitarSegundaEleccion.addActionListener(this);
        quitarSegundaEleccion.setEnabled(false);
	add(quitarSegundaEleccion);
        
        //botones del apartado de informacion
        
        jugar = new JButton("Jugar");
	jugar.setBounds(720,285,120,25);
	jugar.addActionListener(this);
	add(jugar);   

        simulacion = new JButton("Simulacion");
	simulacion.setBounds(720,325,120,25);
	simulacion.addActionListener(this);
	add(simulacion);
                
        //textos apartado de informacion de la simulacion
        
        numJuegos = new JLabel("");
        numJuegos.setBounds(630,355,300,35);
        numJuegos.setBorder(BorderFactory.createTitledBorder("numero de juegos"));
        add(numJuegos);
        
        cambio = new JLabel("");
        cambio.setBounds(630,390,300,35);
        cambio.setBorder(BorderFactory.createTitledBorder("victorias cambio"));
        add(cambio);
        
        cambioPercent = new JLabel("");
        cambioPercent.setBounds(630,425,300,35);
        cambioPercent.setBorder(BorderFactory.createTitledBorder("porcentaje victorias"));
        add(cambioPercent);
        
        insiste = new JLabel("");
        insiste.setBounds(630,460,300,35);
        insiste.setBorder(BorderFactory.createTitledBorder("victorias insiste"));
        add(insiste);
        
        insistePercent = new JLabel("");
        insistePercent.setBounds(630,495,300,35);
        insistePercent.setBorder(BorderFactory.createTitledBorder("porcentaje victorias"));
        add(insistePercent);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        //control del inicio del juego mediante el boton jugar
        if(e.getActionCommand().equals(jugar.getActionCommand())){
            jugar.setEnabled(false);
            simulacion.setEnabled(false);
            
            imagen1.setIcon(puerta);
            imagen2.setIcon(puerta);
            imagen3.setIcon(puerta);
            premio.setIcon(puerta);
            
            primeraEleccion1.setEnabled(true);
            primeraEleccion2.setEnabled(true);
            primeraEleccion3.setEnabled(true);
            
            primeraEleccion.setEnabled(true);
            quitarPrimeraEleccion.setEnabled(true);

            c.generarPuertaGanadora();
            
            
        }
        
        //condicional para las estadisticas de la simulacion
        if(e.getActionCommand().equals(simulacion.getActionCommand())){
            jugar.setEnabled(false);
            int numero = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de simulaciones a realizar"));
            c.simular(numero);
            
            numJuegos.setText(numero + "");
            cambio.setText(c.consultarCambios() + "");
            insiste.setText(c.consultarInsistencias() + "");
            
            cambioPercent.setText(c.getPorcentajeCambios(numero) + "%");
            insistePercent.setText(c.getPorcentajeInsiste(numero) + "%");
            
        }
        
        //condicional para controlar los checkbox de la primera eleccion y esto active los botones
        
        if(primeraEleccion1.isSelected() || primeraEleccion2.isSelected() || primeraEleccion3.isSelected()){
            quitarPrimeraEleccion.setEnabled(true);
            primeraEleccion.setEnabled(true);
            
            primeraEleccion1.setEnabled(false);
            primeraEleccion2.setEnabled(false);
            primeraEleccion3.setEnabled(false);
        }
        
        //control para quitar la primera eleccion, boton quitar eleccion
        
        if(e.getActionCommand().equals(quitarPrimeraEleccion.getActionCommand()) && primeraEleccion1.isSelected() ||
                e.getActionCommand().equals(quitarPrimeraEleccion.getActionCommand()) && primeraEleccion2.isSelected() ||
                e.getActionCommand().equals(quitarPrimeraEleccion.getActionCommand()) && primeraEleccion3.isSelected()){
            
            primeraEleccion1.setSelected(false);
            primeraEleccion2.setSelected(false);
            primeraEleccion3.setSelected(false);
            
            primeraEleccion1.setEnabled(true);
            primeraEleccion2.setEnabled(true);
            primeraEleccion3.setEnabled(true);
            
            quitarPrimeraEleccion.setEnabled(false);
            primeraEleccion.setEnabled(false);
        }
        
        //condicionales para controlar la primera eleccion, boton elegir
        
        if(e.getActionCommand().equals(primeraEleccion.getActionCommand()) && primeraEleccion1.isSelected()){
            segundaEleccion1.setEnabled(true);
            segundaEleccion2.setEnabled(true);   
            segundaEleccion3.setEnabled(true);
            
            c.primeraEleccion(1);
            puertaFalsa = c.puertaFalsa(1);
            if(puertaFalsa == 2){
                imagen2.setIcon(cabra);
                segundaEleccion2.setEnabled(false);
            }else{
                if(puertaFalsa == 3){
                    imagen3.setIcon(cabra);
                    segundaEleccion3.setEnabled(false);
                }
            }
            primeraEleccion.setEnabled(false);
            quitarPrimeraEleccion.setEnabled(false);
        }else{
            if(e.getActionCommand().equals(primeraEleccion.getActionCommand()) && primeraEleccion2.isSelected()){
                segundaEleccion1.setEnabled(true);
                segundaEleccion2.setEnabled(true);   
                segundaEleccion3.setEnabled(true);
                
                c.primeraEleccion(2);
                puertaFalsa = c.puertaFalsa(2);
                if(puertaFalsa == 1){
                    imagen1.setIcon(cabra);
                    segundaEleccion1.setEnabled(false);
                }else{
                    if(puertaFalsa == 3){
                        imagen3.setIcon(cabra);
                        segundaEleccion3.setEnabled(false);
                    }
                }
                primeraEleccion.setEnabled(false);
                quitarPrimeraEleccion.setEnabled(false);
            }else{
                if(e.getActionCommand().equals(primeraEleccion.getActionCommand()) && primeraEleccion3.isSelected()){
                    segundaEleccion1.setEnabled(true);
                    segundaEleccion2.setEnabled(true);   
                    segundaEleccion3.setEnabled(true);
                    
                    c.primeraEleccion(3);
                    puertaFalsa = c.puertaFalsa(3);
                    if(puertaFalsa == 1){
                        imagen1.setIcon(cabra);
                        segundaEleccion1.setEnabled(false);
                    }else{
                        if(puertaFalsa == 2){
                            imagen2.setIcon(cabra);
                            segundaEleccion2.setEnabled(false);
                        }
                    }
                    primeraEleccion.setEnabled(false);
                    quitarPrimeraEleccion.setEnabled(false);
                }
            }
        }
        
        //control de la segunda eleccion para los checkbox y botones
        
        if(segundaEleccion1.isSelected() || segundaEleccion2.isSelected() || segundaEleccion3.isSelected()){
            quitarSegundaEleccion.setEnabled(true);
            segundaEleccion.setEnabled(true);
            
            primeraEleccion.setEnabled(false);
            quitarPrimeraEleccion.setEnabled(false);
            
            segundaEleccion1.setEnabled(false);
            segundaEleccion2.setEnabled(false);
            segundaEleccion3.setEnabled(false);
        }
        
        //condicionales para controlar quitar la segunda eleccion
        
        if(e.getActionCommand().equals(quitarSegundaEleccion.getActionCommand()) && segundaEleccion1.isSelected() ||
                e.getActionCommand().equals(quitarSegundaEleccion.getActionCommand()) && segundaEleccion2.isSelected() ||
                e.getActionCommand().equals(quitarSegundaEleccion.getActionCommand()) && segundaEleccion3.isSelected()){
            
            puertaFalsa = c.getPuertaFalsa();
            if(puertaFalsa == 1){
                segundaEleccion2.setEnabled(true);
                segundaEleccion3.setEnabled(true);
            }else{
                if(puertaFalsa == 2){
                    segundaEleccion1.setEnabled(true);
                    segundaEleccion3.setEnabled(true);
                }else{
                    if(puertaFalsa == 3){
                        segundaEleccion1.setEnabled(true);
                        segundaEleccion2.setEnabled(true);
                    }
                }
            }
            segundaEleccion1.setSelected(false);
            segundaEleccion2.setSelected(false);
            segundaEleccion3.setSelected(false);
            
            quitarSegundaEleccion.setEnabled(false);
            segundaEleccion.setEnabled(false);
            
            primeraEleccion1.setEnabled(false);
            primeraEleccion2.setEnabled(false);
            primeraEleccion3.setEnabled(false);
        }
        
        //control de la segunda eleccion
        
        if(e.getActionCommand().equals(segundaEleccion.getActionCommand()) && segundaEleccion1.isSelected()){
            segundaEleccion.setEnabled(false);
            quitarSegundaEleccion.setEnabled(false);
            
            resultado = c.probarGanador(1);
            if(resultado){
                imagen1.setIcon(carro);
                imagen2.setIcon(cabra);
                imagen3.setIcon(cabra);
                premio.setIcon(carro);
            }else{
                puertaGanadora = c.consultarGanador();
                if(puertaGanadora == 2){
                    imagen1.setIcon(cabra);
                    imagen2.setIcon(carro);
                    imagen3.setIcon(cabra);
                    premio.setIcon(cabra);
                }else{
                    if(puertaGanadora == 3){
                        imagen1.setIcon(cabra);
                        imagen2.setIcon(cabra);
                        imagen3.setIcon(carro);
                        premio.setIcon(cabra);
                    }   
                }
            }
            
        }else{
            if(e.getActionCommand().equals(segundaEleccion.getActionCommand()) && segundaEleccion2.isSelected()){
                segundaEleccion.setEnabled(false);
                quitarSegundaEleccion.setEnabled(false);
                
                resultado = c.probarGanador(2);
                if(resultado){
                    imagen1.setIcon(cabra);
                    imagen2.setIcon(carro);
                    imagen3.setIcon(cabra);
                    premio.setIcon(carro);
                }else{
                    puertaGanadora = c.consultarGanador();
                    if(puertaGanadora == 1){
                        imagen1.setIcon(carro);
                        imagen2.setIcon(cabra);
                        imagen3.setIcon(cabra);
                        premio.setIcon(cabra);
                    }else{
                        if(puertaGanadora == 3){
                            imagen1.setIcon(cabra);
                            imagen2.setIcon(cabra);
                            imagen3.setIcon(carro);
                            premio.setIcon(cabra);
                        }   
                    }
                }
            
            }else{
                if(e.getActionCommand().equals(segundaEleccion.getActionCommand()) && segundaEleccion3.isSelected()){
                    segundaEleccion.setEnabled(false);
                    quitarSegundaEleccion.setEnabled(false);
                    
                    resultado = c.probarGanador(3);
                    if(resultado){
                        imagen1.setIcon(cabra);
                        imagen2.setIcon(cabra);
                        imagen3.setIcon(carro);
                        premio.setIcon(carro);
                    }else{
                        puertaGanadora = c.consultarGanador();
                        if(puertaGanadora == 1){
                            imagen1.setIcon(carro);
                            imagen2.setIcon(cabra);
                            imagen3.setIcon(cabra);
                            premio.setIcon(cabra);
                        }else{
                            if(puertaGanadora == 2){
                                imagen1.setIcon(cabra);
                                imagen2.setIcon(carro);
                                imagen3.setIcon(cabra);
                                premio.setIcon(cabra);
                            }
                        }
                    }
            
                }
            }
        }
    }  
}