package com.bisoft.game.patterns.Comportamiento.Proxy;

public class RealStopwatch implements IStopwatch {

    @Override
    public void tiempo(String tiempo) throws Exception {
        System.out.println("Comenzando JUEGO CALABOZOS Y VAMPIROS: tiempo: "+ tiempo);

    }
}
