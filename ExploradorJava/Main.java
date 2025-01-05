package Clases;

public class Main {
    public static void main(String[] args) {
        bienvenida();





        Mapa tablero = new Mapa();
        tablero.mostrar();

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
}
