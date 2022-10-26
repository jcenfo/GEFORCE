package src.com.bisoft.game.patterns.Creational.Fabrica.ProductoConcreto;


import src.com.bisoft.game.patterns.Creational.Fabrica.Producto.Enemigo;

public class EnemigoNormal extends Enemigo {

    public EnemigoNormal(String tipoEnemigo) {
        setDificultad("Nivel 1");
        setMecanica("Necesario 3 ataques para derribar");
        setTipoEnemigo("Normal");
    }

    /****************** SECCION: Implementación de las funciones abstractas *******************/

    public String getDescripcion() {
        return "Enemigo de tipo  " + this.getTipoEnemigo() + "con tecnica " + this.getMecanica() + "de dificultad " + this.getDificultad();
    }
}
