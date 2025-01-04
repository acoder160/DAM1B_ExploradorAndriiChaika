package Clases;


public class explorador {
    private String nombre;
    private Posicion posicionActual;

    public explorador(String nombre){
        nombre = this.nombre;
        int fila = (int)(Math.random() * 10) + 1;
        posicionActual = new Posicion(fila, 1);
    }

    public void moverse(int lado){
        // System.out.println("Elige a donde deseee moverse:\n 1 - ARRIBA\n2 - ABAJO\n3 - DERECHA\n4 - IZQUIERDA");
        if(lado == 1){
            posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() + 1);
        } else if (lado == 2) {
            posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() - 1);
        } else if (lado == 3) {
            posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() + 1);
        } else if (lado == 4) {
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
