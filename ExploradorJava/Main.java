package Clases;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        bienvenida();
        explorador jugador = new explorador("Jugador");
        Mapa tablero = new Mapa(jugador);
        tablero.mostrar();
        Scanner s = new Scanner(System.in);
        boolean juego = true;
        Enemigo[] enemigo = tablero.getListadoEnemigos();
        Posicion[] trampas = tablero.getPosicionTrampas();
        while(juego) {
            moverse(s, jugador, tablero);
            tablero.mostrar();
            if (jugador.getPosicionActual().getCoordenadaFila() == tablero.getPosTesoro().getCoordenadaFila() && tablero.getPosTesoro().getCoordenadaCol() == jugador.getPosicionActual().getCoordenadaCol()) {
                System.out.println("Felicidades!! Has encontrado el tesoro. Has ganado el juego");
                juego = false;
            }
            for (int i = 0; i < 3; i++) {
                if (enemigo[i].getPosicionActual().getCoordenadaFila() == jugador.getPosicionActual().getCoordenadaFila() && enemigo[i].getPosicionActual().getCoordenadaCol() == jugador.getPosicionActual().getCoordenadaCol()){
                    System.out.println("Te han descubierto los enemigos. Fin del juego");
                    juego = false;
                } else if (trampas[i].getCoordenadaFila() == jugador.getPosicionActual().getCoordenadaFila() && trampas[i].getCoordenadaCol() == jugador.getPosicionActual().getCoordenadaCol()) {
                    System.out.println("Has caido en una trampa. Fin del juego");
                    juego = false;
                }
            }

        }

    }
    public static void bienvenida(){
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println("\n\nBeinvenido al juego del explorador\n");
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println("\n\n");
    }

    public static void moverse(Scanner s, explorador jugador, Mapa tablero){
        boolean permitido = true;
        while (permitido) {
            System.out.println("Elige a donde deseas moverse:\nw - ARRIBA\ns - ABAJO\nd - DERECHA\na - IZQUIERDA");
            char dir = s.next().charAt(0);
            if(dir == 'a' || dir == 's' || dir == 'w' || dir == 'd'){
                if(dir == 'w' && jugador.getPosicionActual().getCoordenadaFila() > 1) {
                    jugador.moverse(1);
                    permitido = false;
                }
                else if(dir == 's' && jugador.getPosicionActual().getCoordenadaFila() < 6){
                    jugador.moverse(2);
                    permitido = false;
                }
                else if(dir == 'd' && jugador.getPosicionActual().getCoordenadaCol() < 20){
                    jugador.moverse(3);
                    permitido = false;
                }
                else if(dir == 'a' && jugador.getPosicionActual().getCoordenadaCol() > 1){
                    jugador.moverse(4);
                    permitido = false;
                }
                else{
                    System.out.println("Error, intentas moverse fuera de la zona permitida, elige otra dirección");
                }
            }
            else{
                System.out.println("Error, la letra introducida no es correcta");
            }
        } // turno de enemigos para moverse.
        Enemigo[] enemigo = tablero.getListadoEnemigos();
        Posicion[] trampa = tablero.getPosicionTrampas();
        int arriba = 5;
        int abajo = 5;
        int derecha = 5;
        int izquierda = 5; // se usa 5 por defecto, pero si cumple con algun if (enemigo encontrado o trampa) prohibira el uso aleatorio del movimiento en Do-while que genera direccion.
        int direccion;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) { // enemigo arriba = fila +1 col ==. abajo fila -1 col ==. derecha fila == col +1. izquierda col -1 fila ==
                if((enemigo[i].getPosicionActual().getCoordenadaCol() == enemigo[j].getPosicionActual().getCoordenadaCol() && enemigo[i].getPosicionActual().getCoordenadaFila() == enemigo[j].getPosicionActual().getCoordenadaFila() + 1) || (enemigo[i].getPosicionActual().getCoordenadaCol() == trampa[j].getCoordenadaCol() && enemigo[i].getPosicionActual().getCoordenadaFila() == trampa[j].getCoordenadaFila() + 1)){
                    arriba = 1;
                } else if ((enemigo[i].getPosicionActual().getCoordenadaCol() == enemigo[j].getPosicionActual().getCoordenadaCol() && enemigo[i].getPosicionActual().getCoordenadaFila() == enemigo[j].getPosicionActual().getCoordenadaFila() - 1) || (enemigo[i].getPosicionActual().getCoordenadaCol() == trampa[j].getCoordenadaCol() && enemigo[i].getPosicionActual().getCoordenadaFila() == trampa[j].getCoordenadaFila() - 1)) {
                    abajo = 2;
                } else if ((enemigo[i].getPosicionActual().getCoordenadaCol() == enemigo[j].getPosicionActual().getCoordenadaCol() + 1 && enemigo[i].getPosicionActual().getCoordenadaFila() == enemigo[j].getPosicionActual().getCoordenadaFila()) || (enemigo[i].getPosicionActual().getCoordenadaCol() == trampa[j].getCoordenadaCol() + 1 && enemigo[i].getPosicionActual().getCoordenadaFila() == trampa[j].getCoordenadaFila())) {
                    derecha = 3;
                } else if ((enemigo[i].getPosicionActual().getCoordenadaCol() == enemigo[j].getPosicionActual().getCoordenadaCol() - 1 && enemigo[i].getPosicionActual().getCoordenadaFila() == enemigo[j].getPosicionActual().getCoordenadaFila()) || (enemigo[i].getPosicionActual().getCoordenadaCol() == trampa[j].getCoordenadaCol() - 1 && enemigo[i].getPosicionActual().getCoordenadaFila() == trampa[j].getCoordenadaFila())) {
                    izquierda = 4;
            }
            do {
                direccion = (int) (Math.random()*4) + 1;
            } while (direccion == arriba || direccion == abajo || direccion == derecha || direccion == izquierda); //si algun enemigo/trampa fue encontrada en la casilla cercana, re generara el numero para no pisar el objeto.
            enemigo[i].moverse(direccion);
        }
    }
}
}

