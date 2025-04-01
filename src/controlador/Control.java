package controlador;

//Esta clase es el punto medio en la aplicaciones, se encarga de comunicar las clases visuales con las de lógica

import modelo.Juego;
import modelo.Simulacion;

public class Control {
    Juego juego = new Juego();
    Simulacion simulacion = new Simulacion();
    
    //metodos que se comunican con la clase juego
    
    //metodo para llamar la creacion de puerta ganadora
    public void generarPuertaGanadora(){
        juego.generarPuertaGanadora();
    }
    
    //metodo para establecer la primera eleccion del jugador
    public void primeraEleccion(int puertaActual){
        juego.setPuertaActual(puertaActual);
    }
    
    //metodo para crear y retornar la puerta que posee una cabra y es mostrada al jugador
    public int puertaFalsa(int puertaActual){
        return juego.generarPuertaFalsaDueño(puertaActual);
    }
    
    //metodo para consultar la puerta falsa
    public int getPuertaFalsa(){
        return juego.getPuertaDueñoFalsa();
    }
    
    //metodo para comprobar la puerta de la segunda eleccion con la puerta ganadora, comprobar si se gana o no
    public boolean probarGanador(int puertaEntrante){
        return juego.comprobarGanador(puertaEntrante);
    }
    
    //metodo para consultar la puerta ganadora
    public int consultarGanador(){
        return juego.getPuertaGanadora();
    }
    
    //metodos que se comunican con la clase simulacion
    
    //metodo para generar la simulacion
    public void simular(int numSimulaciones){
        simulacion.juego(numSimulaciones);
    }
    
    //metodo para ver el numero de juegos en los que los cambios ganan
    public int consultarCambios(){
        return simulacion.getCambioEleccion();
    }
    
    //metodo para ver el porcentaje de victoria mediante cambio de eleccion
    public double getPorcentajeCambios(int numSimulaciones){
        return simulacion.porcentajeVictoriaCambio(numSimulaciones);
    }
    
    //metodo para ver el numero de juegos en los que las insistencias en la misma eleccion ganan
    public int consultarInsistencias(){
        return simulacion.getInsisteEleccion();
    }
    
    //metodo para ver e porcentaje de victoria mediante la misma eleccion
    public double getPorcentajeInsiste(int numSimulaciones){
        return simulacion.porcentajeVictoriaInsiste(numSimulaciones);
    }
    
}