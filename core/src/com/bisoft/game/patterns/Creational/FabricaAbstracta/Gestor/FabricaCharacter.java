package com.bisoft.game.patterns.Creational.FabricaAbstracta.Gestor;

import com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaAbstractaCharacter.GameCharacter;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaConcreta.FabricaGuerrero;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaConcreta.FabricaMago;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaConcreta.FabricaMercenario;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;

public class FabricaCharacter {

    //arreglo de personajes

    private static Character arCharacter;

    // constructor
    public FabricaCharacter() {

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
        FabricaCharacter.arCharacter = arCharacter;
    }

    //Opciones para los 3 tipos de personajes

    public static String processFunction(int pOpc) {
        String sMessage = "";
        switch (pOpc) {
            case 1:
                //Crea un guerrero
                GameCharacter tiChara = new FabricaGuerrero();
                sMessage = CreateFabricaCharacter(tiChara);
                break;
            case 2:
                //Crea un mercenario
               GameCharacter tiChara1 = new FabricaMercenario();
               sMessage = CreateFabricaCharacter(tiChara1);
                break;
            case 3:
                //Crea un Mago
                GameCharacter tiChara2 = new FabricaMago();
                sMessage = CreateFabricaCharacter(tiChara2);
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
