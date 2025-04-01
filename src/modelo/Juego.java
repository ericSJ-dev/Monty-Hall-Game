package modelo;

import java.util.Random;

//Esta clase se encarga de todas las acciones necesarias para la ejecución y logica del juego principal
public class Juego {
    Random random = new Random();
    
    private int puertaGanadora;
    private int puertaActual;
    private int puertaDueñoFalsa;
    private int puertaEntrante;
    private boolean cambio;
    private boolean resultado;
    private int aleatorioFalso;
    
    private int numeroCambios;
    private int numeroInsiste;
    private double percentNumeroCambios;
    private double percentNumeroInsiste;
    
    public Juego(){
    }
    public Juego(int puertaGanadora, int puertaDueñoFalsa, int puertaActual, int puertaEntrante, boolean cambio, 
            boolean resultado, int numeroCambios, int numeroInsiste, double percentNumeroCambios, double percentNumeroInsiste){
        this.puertaGanadora = puertaGanadora;
        this.puertaDueñoFalsa = puertaDueñoFalsa;
        this.puertaActual = puertaActual;
        this.puertaEntrante = puertaEntrante;
        this.cambio = cambio;
        this.resultado = resultado;
        this.numeroCambios = numeroCambios;
        this.numeroInsiste = numeroInsiste;
        this.percentNumeroCambios = percentNumeroCambios;
        this.percentNumeroInsiste = percentNumeroInsiste;
    }
    
    //metodo para generar la puerta ganadora
    
    public void generarPuertaGanadora(){
        puertaGanadora = random.nextInt(3)+ 1;
    }

    //metodo para generar la puerta que es revelada al concursante y siempre tiene una cabra
    
    public int generarPuertaFalsaDueño(int puertaActual){
        aleatorioFalso = random.nextInt(2)+1;
        if(puertaActual == 1){
            if(puertaGanadora == 1){
                if(aleatorioFalso == 1){
                    puertaDueñoFalsa = 2;
                }else{
                    if(aleatorioFalso == 2){
                        puertaDueñoFalsa = 3;
                    }
                }
            }else{
                if(puertaGanadora == 2){
                    puertaDueñoFalsa = 3;
                }else{
                    if(puertaGanadora == 3){
                        puertaDueñoFalsa = 2;
                    }
                }
            }
        }else{
            if(puertaActual == 2){
                if(puertaGanadora == 2){
                    if(aleatorioFalso == 1){
                        puertaDueñoFalsa = 1;
                    }else{
                        if(aleatorioFalso == 2){
                            puertaDueñoFalsa = 3;
                        }
                    }
                }else{
                    if(puertaGanadora == 1){
                        puertaDueñoFalsa = 3;
                    }else{
                        if(puertaGanadora == 3){
                            puertaDueñoFalsa = 1;
                        }
                    }
                }
            }else{
                if(puertaActual == 3){
                    if(puertaGanadora == 3){
                        if(aleatorioFalso == 1){
                            puertaDueñoFalsa = 1;
                        }else{
                            if(aleatorioFalso == 2){
                                puertaDueñoFalsa = 2;
                            }
                        }
                    }else{
                        if(puertaGanadora == 1){
                            puertaDueñoFalsa = 2;
                        }else{
                            if(puertaGanadora == 2){
                                puertaDueñoFalsa = 1;
                            }
                        }
                    }
                }
            }
        }
        return puertaDueñoFalsa;
    }
    
    //metodo para comprobar la coincidencia entre la eleccion 1 y 2
    
    public boolean comprobarCambio(){
        if(getPuertaEntrante() == getPuertaActual()){
            cambio = false;
        }else{
            cambio = true;
        }
        return cambio;
    }
    
    //metodo para comprobar exactamente el tipo de eleccion
    
    public String tipoEleccion(){
        String eleccion = "";
        if(comprobarCambio() == true){
            eleccion = "cambia";
        }else{
            eleccion = "insiste";
        }
        return eleccion;
    }
    
    //metodo para agregar la cantidad de veces que cambia o no en las partidas
    public void addNumElecciones(){
        String aux = tipoEleccion();
        if(aux.equals("cambia")){
            numeroCambios ++;
        }else{
            numeroInsiste ++;
        }
    }
    
    //metodo para saber el porcentaje de elecciones de cada
    
    public void porcentajeElecciones(int numPartidas){
        double aux1 = (double)getNumeroCambios()/numPartidas;
        aux1 = aux1 * 100;
        setPercentNumeroCambios(aux1);
        
        double aux2 = (double)getNumeroInsiste()/numPartidas;
        aux2 = aux2 * 100;
        setPercentNumeroInsiste(aux2);
    }
    
    //metodo que compara la ultima eleccion del jugador con la puerta ganadora
    
    public boolean comprobarGanador(int puertaEntrante){
        if(puertaEntrante == puertaGanadora){
            resultado = true;
        }else{
            resultado = false;
        }
        return resultado;
    }
    
    //metodo para conocer si es ganador o no
    
    public String resultado(){
        String premio = "";
        if(getPuertaEntrante() == getPuertaGanadora()){
           premio = "ganador";
        }else{
            premio = "perdedor";
        }
        return premio;
    }

    //metodos get y set
    
    public int getNumeroCambios() {
        return numeroCambios;
    }

    public void setNumeroCambios(int numeroCambios) {
        this.numeroCambios = numeroCambios;
    }
    
    public int getNumeroInsiste() {
        return numeroInsiste;
    }
    
    public void setNumeroInsiste(int numeroInsiste) {    
        this.numeroInsiste = numeroInsiste;
    }
    
    //get y set de porcentajes
    public double getPercentNumeroCambios() {
        return percentNumeroCambios;
    }

    public void setPercentNumeroCambios(double percentNumeroCambios) {
        this.percentNumeroCambios = percentNumeroCambios;
    }
    
    public double getPercentNumeroInsiste() {
        return percentNumeroInsiste;
    }
    
    public void setPercentNumeroInsiste(double percentNumeroInsiste) {    
        this.percentNumeroInsiste = percentNumeroInsiste;
    }

    public int getPuertaGanadora() {
        return puertaGanadora;
    }

    public void setPuertaGanadora(int puertaGanadora) {
        this.puertaGanadora = puertaGanadora;
    }

    public int getPuertaActual() {
        return puertaActual;
    }

    public void setPuertaActual(int puertaActual) {
        this.puertaActual = puertaActual;
    }

    public int getPuertaDueñoFalsa() {
        return puertaDueñoFalsa;
    }

    public void setPuertaDueñoFalsa(int puertaDueñoFalsa) {
        this.puertaDueñoFalsa = puertaDueñoFalsa;
    }

    public int getPuertaEntrante() {
        return puertaEntrante;
    }

    public void setPuertaEntrante(int puertaEntrante) {
        this.puertaEntrante = puertaEntrante;
    }

    public boolean isCambio() {
        return cambio;
    }

    public void setCambio(boolean cambio) {
        this.cambio = cambio;
    }
    
}