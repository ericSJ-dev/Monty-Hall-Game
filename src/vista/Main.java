package vista;

public class Main {

    //Esta aplicación permite simular el juego de probabilidad de Monty Hall mediante una inteerfaz visual
    //en el juego existen 3 opciones para nuestra elección, en una de ellas 
    //está el premio que es un vehiculo de lujo y en las otras dos hay una cabra por premio

    public static void main(String []args){
        FrameJuego juego = new FrameJuego();
        juego.setVisible(true);
	}
}

    //el juego funciona asi: se realiza la primera elección
    //posteriormente nos enseñan una de las dos puertas restantes con una cabra (sin premio)
    //lo que nos deja con solo dos opciones, la actual y la otra opcion posible

    //ahora, según la probabilidad de Monty Hall, la mejor opcion que tenemos es hacer un cambio de eleccion
    //debido a que la probabilidad se distribuye de la siguiente manera:

    //en la primera elección cada puerta posee un 33.3% de posibilidad de contener el premio
    //por lo que en el momento de elegir la primera vez tenemos un 33.3% de probabilidad de ganar
    //y un 66.6% de probabilidades de perder, este porcentaje se encuentra contenido en las otras dos puertas
    //sin embargo, luego de nuestra primera elección se nos muestra el contenido de una de las dos puertas (un premio errado, obviamente)
    //este cambio hace que las dos puertas que contenian el 66.6% de probabilidad de perdida se mantenga
    //pero se mantiene en la puerta que queda restante. por lo que en ese momento se nos solicita 
    //realizar otra elección, ya sea conservar nuestra primera elección 
    //(la cual en terminos de probabilidad contiene un 33.3% de probabilidad de victoria)
    //O podemos cambiar de elección, y esto nos dejaria con la puerta restante que contiene 66.6% de probabilidad en este momento
    //por eso la mejor alternativa es realizar el cambio elección en este momento y asi tener mas posibilidades de ganar