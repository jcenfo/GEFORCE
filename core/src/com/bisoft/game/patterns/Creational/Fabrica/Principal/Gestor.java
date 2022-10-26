package src.com.bisoft.game.patterns.Creational.Fabrica.Principal;


import src.com.bisoft.game.patterns.Creational.Fabrica.Creador.MetodoFabrica;
import src.com.bisoft.game.patterns.Creational.Fabrica.CreadorConcreto.FabricaDeEnemigos;
import src.com.bisoft.game.patterns.Creational.Fabrica.Producto.Enemigo;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {

    private static Scanner sc = new Scanner(System.in);

    private static ArrayList <Enemigo> arrEnemigos = new ArrayList<Enemigo>();
    private static MetodoFabrica gFabrica;

    public Gestor() {
        gFabrica = new FabricaDeEnemigos();
    }

    public static String nuevoEnemigo(MetodoFabrica fabrica, String pTipoEnemigo) {
        Enemigo objEnemigo = (Enemigo) fabrica.crearEnemigo(pTipoEnemigo);
        addEnemigoArray(objEnemigo);


        return objEnemigo.getDescripcion();
    }

    private static void addEnemigoArray(Enemigo pObj) {

        arrEnemigos.add(pObj);


    }

    public String obtenerDatos() {
        String mResult = "";
        for (Enemigo mEn : arrEnemigos)	{
            mResult = mResult + mEn.getDescripcion() + "\n"
                    +"Su dificultad es de: " + mEn.getDificultad() + "\n"
                    +"Su mecanica es: " + mEn.getMecanica() + "\n";

        }

        return mResult;

    }


    public static String procesarFuncion(int opcion ) {
        String sMensaje ="";
        MetodoFabrica enemigo;

        switch (opcion) {

            case 1:
                System.out.println("Ingrese el tipo de enemigo que desea crear: Jefe, Normal o Subjefe)  ");
                String tipoEnemigo = sc.next();

                enemigo = new FabricaDeEnemigos();
                sMensaje = nuevoEnemigo(enemigo, tipoEnemigo);

                break;

            case 2:
                sMensaje = "Salir";
                break;

            default:
                sMensaje = "Opcion invalida";
                break;
        }

        return sMensaje ;

    }



}