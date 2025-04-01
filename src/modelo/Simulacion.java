package modelo;

import java.util.Random;

//Esta clase se usa para hacer la simulación del juego en el apartado inferior derecho de la pantalla de la aplicación
public class Simulacion {
    Random aleatorio = new Random();
    
    //atributos para el cambio e insistencia de eleccion y para el manejo de las cajas
    private int cambioEleccion;
    private int insisteEleccion;
    
    private int cajaGanadora;
    private int cajaDueñoFalsa;
    private int cajaJugador;
    private int nuevaCaja;
    
    public Simulacion(){
    }
    
    public Simulacion(int cambioEleccion, int insisteEleccion, int cajaGanadora, int cajaDueñoFalsa, 
        int cajaJugador, int nuevaCaja){
        this.cambioEleccion = cambioEleccion;
        this.insisteEleccion = insisteEleccion;
        this.cajaGanadora = cajaGanadora;
        this.cajaDueñoFalsa = cajaDueñoFalsa;
        this.cajaJugador = cajaJugador;
        this.nuevaCaja = nuevaCaja;
    }
    
    //metodo de la simulacion
    
    public void juego(int numSimulaciones){
        cambioEleccion = 0;
        insisteEleccion = 0;
        
        for(int i = 0;i < numSimulaciones; i ++){
            cajaGanadora = aleatorio.nextInt(3)+1;
            cajaJugador = aleatorio.nextInt(3)+1;           
            cajaDueñoFalsa = -1;
            
            if(cajaGanadora == cajaJugador){
                do{
                    cajaDueñoFalsa = aleatorio.nextInt(3)+1;
                }while(cajaDueñoFalsa == cajaGanadora);
            }else{
                do{
                    cajaDueñoFalsa = aleatorio.nextInt(3)+1;
                }while(cajaDueñoFalsa == cajaGanadora || cajaDueñoFalsa == cajaJugador);
            }
            
            if(cajaGanadora == cajaJugador){
                insisteEleccion ++;
            }
            
            nuevaCaja = -1;
            do{
                nuevaCaja = aleatorio.nextInt(3)+1;
            }while(nuevaCaja == cajaDueñoFalsa || nuevaCaja == cajaJugador);
            
            if(nuevaCaja == cajaGanadora){
                cambioEleccion ++;
            }
        
        }
        
        setInsisteEleccion(insisteEleccion);
        setCambioEleccion(cambioEleccion);
        
    }
    
    //metodo para calcular el porcentaje de victorias con cambio de eleccion
    public double porcentajeVictoriaCambio(int numSimulaciones){
        double aux = (double)cambioEleccion/numSimulaciones;
        return aux * 100;
    }
    
    //metodo para calcular el porcentaje de victorias con la misma eleccion
    public double porcentajeVictoriaInsiste(int numSimulaciones){
        double aux = (double)insisteEleccion/numSimulaciones;
        return aux * 100;
    }

    //metodos get y set
    
    public int getCambioEleccion() {
        return cambioEleccion;
    }

    public void setCambioEleccion(int cambioEleccion) {
        this.cambioEleccion = cambioEleccion;
    }

    public int getInsisteEleccion() {
        return insisteEleccion;
    }

    public void setInsisteEleccion(int insisteEleccion) {
        this.insisteEleccion = insisteEleccion;
    }

    public int getCajaGanadora() {
        return cajaGanadora;
    }

    public void setCajaGanadora(int cajaGanadora) {
        this.cajaGanadora = cajaGanadora;
    }

    public int getCajaDueñoFalsa() {
        return cajaDueñoFalsa;
    }

    public void setCajaDueñoFalsa(int cajaDueñoFalsa) {
        this.cajaDueñoFalsa = cajaDueñoFalsa;
    }

    public int getCajaJugador() {
        return cajaJugador;
    }

    public void setCajaJugador(int cajaJugador) {
        this.cajaJugador = cajaJugador;
    }
    
}