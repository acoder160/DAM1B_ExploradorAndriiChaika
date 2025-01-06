package Clases;


public class Enemigo {
    private Posicion posicionActual;


    // Es un lio el enunciado del constructor de enemigo ya que es 100% copiado de la clase explodar, y no cuadra con esta clase asi que he hecho la decision de sequir con la estructura y la logica del ejercicio.
    public Enemigo(){
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
