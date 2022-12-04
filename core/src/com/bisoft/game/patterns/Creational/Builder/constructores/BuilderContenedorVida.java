package com.bisoft.game.patterns.Creational.Builder.constructores;

import com.bisoft.game.patterns.Creational.Builder.constructores.AComponenteProducto;
import com.bisoft.game.patterns.Creational.Builder.objetos.*;


import java.util.ArrayList;

public class BuilderContenedorVida extends AComponenteProducto {
    public BuilderContenedorVida(){
        this.setIndice(3);
    }


    public void construirComponente(int pId, int pPrecio, Items pItems, Habitacion pHabitacion, ContenedorVida pContenedor, int pArma, int pMoneda, int pPosion, int pLlave) throws Exception {
        throw new Exception("La funcion [consstruirComponente] con nueve parametros no esta disponible");
    }


    public void construirComponente(int pId, String pDescripcion, ArrayList<Cenfomonedas> pCenfomonedas, ArrayList<Posiones> pPosiones, ArrayList<Armas> pArmas, ArrayList<Llave> pLlaves) throws Exception {
        throw new Exception("La funcion [consstruirComponente] con seis parametros no esta disponible");
    }

    @Override
    public void construirComponente(int pId, boolean pEspecial) throws Exception {

        throw new Exception("La funcion [consstruirComponente] con dos parametros no esta disponible");
    }

    @Override
    public void construirComponente(int pId, String pNombre, int pNivel, String pDescripcion) throws Exception {

        throw new Exception("La funcion [consstruirComponente] con cuatro parametros no esta disponible");

    }

    @Override
    public void construirComponente(int pId, int pNivel, String pDescripcion) throws Exception {
        throw new Exception("La funcion [consstruirComponente] con tres parametros no esta disponible");

    }

    @Override
    public void construirComponente(int pPiezas) throws Exception {
        this.set_Componente(new ContenedorVida(pPiezas));

    }

    @Override
    public void construirComponente(String enemigo, String rompecabezas, String cofre, int areasRec, int checkpoint, String puerta, boolean estadoJefe) throws Exception {

        throw new Exception("La funcion [consstruirComponente] con siete parametros no esta disponible");
    }


    public void set_Componente(IComponenteProducto pComponente) {
        this._Componente.set(getIndice(), pComponente);


    }

    @Override
    public IComponenteProducto getSet_Componente() {
        return this._Componente.get(getIndice());
    }
}