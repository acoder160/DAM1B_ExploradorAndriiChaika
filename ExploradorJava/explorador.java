package Clases;
import java.util.Scanner;

public class explorador {
    private String nombre;
    private Posicion posicionActual;

    public explorador(String nombre){
        nombre = this.nombre;
        int fila = (int)(Math.random() * 6) + 1;
        posicionActual = new Posicion(fila, 1);
    }

    public void moverse(int direccion){
        //System.out.println("Elige a donde deseee moverse:\n 1 - ARRIBA\n2 - ABAJO\n3 - DERECHA\n4 - IZQUIERDA");
        if(direccion == 1){
            posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() - 1);
        } else if (direccion == 2) {
            posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() + 1);
        } else if (direccion == 3) {
            posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() + 1);
        } else if (direccion == 4) {
            posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() - 1);
        }

    }


    //geters y seters:

    public String getNombre(){
        return nombre;
    }
    public Posicion getPosicionActual(){
        return posicionActual;
    }
    public void setPosicionActual(Posicion posicionActual){
        this.posicionActual = posicionActual;
    }

}
