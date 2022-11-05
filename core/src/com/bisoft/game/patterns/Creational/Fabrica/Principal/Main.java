package src.com.bisoft.game.patterns.Creational.Fabrica.Principal;


import src.com.bisoft.game.patterns.Creational.Fabrica.Creador.MetodoFabrica;


import java.util.Scanner;

public class Main {
    private static Gestor gGestor= new Gestor();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        boolean salir = false;
        int opcion;
        String mensaje;

        MetodoFabrica enemigo;

        int iOpc = 0;

        do {
            iOpc = mostrarMenu();
            System.out.print(Gestor.procesarFuncion(iOpc));
        } while (iOpc !=4 );

    }

    private static int mostrarMenu() {
        String cad="";

        cad=cad+"\n";
        cad=cad+"Ingrese la opcion correspondiente: \n";
        cad=cad+"1. Crear enemigo\n";
        cad=cad+"2. Listar enemigos presentes\n";
        cad=cad+"3. Salir\n";

        cad=cad+"\n";

        System.out.println(cad);

        return sc.nextInt();

    }




}