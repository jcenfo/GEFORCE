package com.bisoft.game.patterns.Creational.Builder.main;

import com.bisoft.game.patterns.Creational.Builder.directores.DirectorComponenteProducto;


import java.sql.Connection;
import java.util.Scanner;

public class MainBuilder {


    private static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }


    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        int iOpcDos = 0;
        int iOpc = 0;
        do {
            iOpc = mostrarMenu();
            System.out.print(GestorBuilder.procesarFuncion(iOpc));
            if (iOpc == 1){
                iOpcDos = mostrarMenuDos();
                System.out.print(GestorBuilder.procesarFuncionDos(iOpcDos));
            }

        } while (iOpc != 6);

    }

    private static int mostrarMenu() {
        String cad = "";

        cad = cad + "\n";
        cad = cad + "Ingrese el numero del articulo deseado\n";
        cad = cad + "1.Item\n";
        cad = cad + "2.Habitacion\n";
        cad = cad + "3.Pieza de contenedor\n";

        cad = cad + "0.Salir\n";
        cad = cad + "\n";

        System.out.println(cad);
        return s.nextInt();
    }

    private static int mostrarMenuDos() {
        String cad = "";

        cad = cad + "\n";
        cad = cad + "Ingrese el numero del articulo deseado\n";
        cad = cad + "1.Arma\n";
        cad = cad + "2.Pocion\n";
        cad = cad + "3.Moneda\n";
        cad = cad + "4.Llave\n";

        cad = cad + "0.Salir\n";
        cad = cad + "\n";

        System.out.println(cad);
        return s.nextInt();
    }






}
