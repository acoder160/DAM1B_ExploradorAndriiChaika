package Clases;

public class Mapa {
    private char[][] tablero; // = new char[6][20]; //tablero tendra 6 filas y 20 columnas
    private Posicion posTesoro;
    private Posicion posJugador;
    private Enemigo[] listadoEnemigos;
    private Posicion[] posicionTrampas;
    private EnemigoInteligente perseguidor;


    public Mapa(explorador jugador){
        tablero = new char[6][20];
        listadoEnemigos = new Enemigo[3];
        posicionTrampas = new Posicion[3];
        perseguidor = new EnemigoInteligente();
        posTesoro = new Posicion((int)(Math.random() * 6) + 1,(int)(Math.random() * 20) + 1); // creamos tesoro
        this.posJugador = jugador.getPosicionActual();
        int col;
        int fila;
        for (int listaEnemigos = 0; listaEnemigos < 3; listaEnemigos++) { //crea 3 enemigos
            listadoEnemigos[listaEnemigos] = new Enemigo();
        }
        posicionTrampas[0] = new Posicion((int)(Math.random() * 6) + 1,(int)(Math.random() * 20) + 1); // creacion de trampa 1
        do{
            fila = (int)(Math.random() * 6) + 1;
            col = (int)(Math.random() * 20) + 1;
            } while (posicionTrampas[0].getCoordenadaCol() - col <=3 && posicionTrampas[0].getCoordenadaCol() - col > -3); // creacion de trampa 2 con la logica de que distancia sera mayor de 3 columnas
            posicionTrampas[1] = new Posicion(fila, col);
        do{
            fila = (int)(Math.random() * 6) + 1;
            col = (int)(Math.random() * 20) + 1;
        } while ((posicionTrampas[0].getCoordenadaCol() - col <=3 && posicionTrampas[0].getCoordenadaCol() - col > -3) || (posicionTrampas[1].getCoordenadaCol() - col <=3 && posicionTrampas[1].getCoordenadaCol() - col > -3)); // creacion de la trampa 3 pero que distancia sera mayor de 3 de la trampa 1 y 3
        posicionTrampas[2] = new Posicion(fila, col);
    }

    // seters y geters

    public void mostrar(){
        for (int fila = 1; fila <= 6; fila++) {
            for (int borde = 1; borde <= 20; borde++) {
                System.out.print("----");
            }
            System.out.println();
            for (int col = 1; col <= 21; col++) { // de 21 para cerrar con un |
                if (posJugador.getCoordenadaFila() == fila && posJugador.getCoordenadaCol() == col){
                    System.out.print("| J ");
                } else if((listadoEnemigos[0].getPosicionActual().getCoordenadaFila() == fila && listadoEnemigos[0].getPosicionActual().getCoordenadaCol() == col) || (listadoEnemigos[1].getPosicionActual().getCoordenadaFila() == fila && listadoEnemigos[1].getPosicionActual().getCoordenadaCol() == col) || (listadoEnemigos[2].getPosicionActual().getCoordenadaFila() == fila && listadoEnemigos[2].getPosicionActual().getCoordenadaCol() == col)){
                    System.out.print("| E ");
                } else if ((posicionTrampas[0].getCoordenadaFila() == fila && posicionTrampas[0].getCoordenadaCol() == col) || (posicionTrampas[1].getCoordenadaFila() == fila && posicionTrampas[1].getCoordenadaCol() == col) || (posicionTrampas[2].getCoordenadaFila() == fila && posicionTrampas[2].getCoordenadaCol() == col)) {
                    System.out.print("| T ");
                } else if (perseguidor.getPosicionActual().getCoordenadaCol() == col && perseguidor.getPosicionActual().getCoordenadaFila() == fila){
                    System.out.print("|*E*");
                } else{
                System.out.print("|   ");
                }
            }
            System.out.println();
        }
    }
    public char[][] getTablero(){
        return tablero;
    }
    public Posicion getPosTesoro(){
        return posTesoro;
    }
    public Enemigo[] getListadoEnemigos(){
        return listadoEnemigos;
    }
    public Posicion[] getPosicionTrampas(){
        return posicionTrampas;
    }

    public EnemigoInteligente getPerseguidor() {
        return perseguidor;
    }
}
