package src.com.bisoft.game.patterns.Creational.Fabrica.CreadorConcreto;


import src.com.bisoft.game.patterns.Creational.Fabrica.Creador.MetodoFabrica;
import src.com.bisoft.game.patterns.Creational.Fabrica.Producto.Enemigo;
import src.com.bisoft.game.patterns.Creational.Fabrica.ProductoConcreto.EnemigoJefe;
import src.com.bisoft.game.patterns.Creational.Fabrica.ProductoConcreto.EnemigoNormal;
import src.com.bisoft.game.patterns.Creational.Fabrica.ProductoConcreto.EnemigoSubjefe;

public class FabricaDeEnemigos implements MetodoFabrica {

    /****************** SECCION: Implementación de las funciones abstractas *******************/

    public Enemigo crearEnemigo(String tipoEnemigo) {
        if((tipoEnemigo.equalsIgnoreCase("Normal")))
            return new EnemigoNormal(tipoEnemigo);
        else
        if((tipoEnemigo.equalsIgnoreCase("Jefe")))
            return new EnemigoJefe(tipoEnemigo);
        else
            return new EnemigoSubjefe(tipoEnemigo);
    }
}
