package Clases;

public class EnemigoInteligente {
    private Posicion posicionActual;



    public EnemigoInteligente(){
        int fila = (int)(Math.random() * 6) + 1;
        int col = (int)(Math.random() * 20) + 1;
        posicionActual = new Posicion(fila, col);
    }

    public void moverse(int direccion){
        if(direccion == 1 && posicionActual.getCoordenadaFila() > 1){
            posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() - 1);
        } else if (direccion == 2 && posicionActual.getCoordenadaFila() < 6) {
            posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() + 1);
        } else if (direccion == 3 && posicionActual.getCoordenadaCol() < 20) {
            posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() + 1);
        } else if (direccion == 4 && posicionActual.getCoordenadaCol() > 1) {
            posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() - 1);
        }
    }

    // geters y seters
    public Posicion getPosicionActual(){
        return posicionActual;
    }
    public void setPosicionActual(Posicion posicionActual){
        this.posicionActual = posicionActual;
    }

}


