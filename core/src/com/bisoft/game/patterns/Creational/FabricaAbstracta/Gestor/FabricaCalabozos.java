package com.bisoft.game.patterns.Creational.FabricaAbstracta.Gestor;

import com.bisoft.game.menucharacter.JuegoCalabozo;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaAbstractaCharacter.GameCharacter;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaConcreta.FabricaGuerrero;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaConcreta.FabricaMago;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaConcreta.FabricaMercenario;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft.game.screen.LoreScreen;
import com.bisoft.game.screen.MenuDiferentesCalabozosScreen;
import com.bisoft.game.screen.MenuJuegoScreen;
import com.bisoft.game.utils.Render;
import com.bisoft.game.utils.Resources;

public class FabricaCalabozos {

    //arreglo de personajes

    private static Character arCharacter;
    private static LoreScreen loreScreen = new LoreScreen();

    // constructor
    public FabricaCalabozos() {

    }


    //crear personajes

    public static String CreateFabricaCharacter(GameCharacter pFabrica) {
        Character objCharacter = pFabrica.createCharacter();
        arCharacter = objCharacter;

        return objCharacter.info_Character();
    }


    public static String get_information_Character() {
        String msDatos = "";

        msDatos = msDatos + arCharacter.info_Character() + "\n";

        return msDatos;
    }

    public Character getCharacter() {
        return arCharacter;
    }

    public void setCharacter(Character arCharacter) {
        FabricaCalabozos.arCharacter = arCharacter;
    }

    //Opciones para los 3 tipos de personajes

    public static String processFunction(int pOpc) {
        String sMessage = "";
        switch (pOpc) {
            case 1:

                System.out.println("Estoy jugando default");
                Resources.MAIN.setScreen(new JuegoCalabozo());
                break;
            case 2:
                System.out.println("Estoy por elegir calabozo");
                Resources.MAIN.setScreen(new MenuDiferentesCalabozosScreen());
                break;
            case 3:
                //Crea un Mago
                GameCharacter tiChara2 = new FabricaMago();
                sMessage = CreateFabricaCharacter(tiChara2);
                Render.close();
                break;
            case 4:
                sMessage = get_information_Character();
                break;
            case 5:
                sMessage = "Thank you for using the software";
                break;
            default:
                sMessage = "Invalid option";
        }

        return sMessage;
    }



}
