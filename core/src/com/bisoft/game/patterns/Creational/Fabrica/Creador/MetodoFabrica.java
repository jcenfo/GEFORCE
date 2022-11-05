package src.com.bisoft.game.patterns.Creational.Fabrica.Creador;


import src.com.bisoft.game.patterns.Creational.Fabrica.Producto.Enemigo;

public interface MetodoFabrica {

    public Enemigo crearEnemigo (String tipoEnemigo);
}
