package com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto;

public interface Character {

    //Metodos para utilizar en la fabrica

    int getLevel();

    void setLevel(int pDif);

    void setDefense(int defense);
    int getDefense();

    String getTipeCharacter();
    String info_Character();

    void setExperience(int experience);
    int getExperience();


    void setAttack(int attacK);
    int getAttack();




}
