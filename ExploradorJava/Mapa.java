package Clases;

public class Mapa {
    private char[][] tablero; // = new char[6][20]; //tablero tendra 6 filas y 20 columnas
    private Posicion posTesoro;
    private Posicion posJugador;
    private Enemigo[] listadoEnemigos;
    private Posicion[] posicionTrampas;


    public Mapa(){
        tablero = new char[6][20];
        listadoEnemigos = new Enemigo[3];
        posicionTrampas = new Posicion[3];
        posTesoro = new Posicion((int)(Math.random() * 6) + 1,(int)(Math.random() * 20) + 1); // creamos tesoro
        for (int listaEnemigos = 0; listaEnemigos < 3; listaEnemigos++) { //crea 3 enemigos
            listadoEnemigos[listaEnemigos] = new Enemigo();
        }
        for (int trampas = 0; trampas < 3; trampas++) { //crea tres trampas
            posicionTrampas[trampas] = new Posicion((int)(Math.random() * 6) + 1,(int)(Math.random() * 20) + 1);
        }
    }

    // seters y geters

    public void mostrar(){
        for (int fila = 1; fila <= 6; fila++) {
            for (int borde = 1; borde <= 20; borde++) {
                System.out.print("----");
            }
            System.out.println();
            for (int col = 1; col <= 21; col++) { // de 21 para cerrar con un |
                if((listadoEnemigos[0].getPosicionActual().getCoordenadaFila() == fila && listadoEnemigos[0].getPosicionActual().getCoordenadaCol() == col) || (listadoEnemigos[1].getPosicionActual().getCoordenadaFila() == fila && listadoEnemigos[1].getPosicionActual().getCoordenadaCol() == col) || (listadoEnemigos[2].getPosicionActual().getCoordenadaFila() == fila && listadoEnemigos[2].getPosicionActual().getCoordenadaCol() == col)){
                    System.out.print("| E ");
                } else if ((posicionTrampas[0].getCoordenadaFila() == fila && posicionTrampas[0].getCoordenadaCol() == col) || (posicionTrampas[1].getCoordenadaFila() == fila && posicionTrampas[1].getCoordenadaCol() == col) || (posicionTrampas[2].getCoordenadaFila() == fila && posicionTrampas[2].getCoordenadaCol() == col)) {
                    System.out.print("| T ");
                } else{
                System.out.print("|   ");
                }
            }
            System.out.println();
        }
    }
}
