package com.bisoft.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.bisoft.game.Inputs.Inputs;
import com.bisoft.game.characters.Player;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft.game.patterns.Structural.Adapter.objetos.MyRectangle;
import com.bisoft.game.patterns.Structural.Adapter.adaptador.MyRectangleAdapter;
import com.bisoft.game.patterns.Structural.Decorator.componente.Colision;
import com.bisoft.game.patterns.Structural.Decorator.gestor.GestorDecorador;
import com.bisoft.game.utils.Pantalla;
import com.bisoft.game.utils.Render;
import com.bisoft.game.utils.Resources;
import com.bisoft.game.utils.WorldContactListener;

import java.util.Objects;

public class RoomDelTiempo implements Screen {
    private Texture rectangle;
    private Render render = new Render();
    private Inputs input;
    private Pantalla screen;
    private float posicionAnteriorX = -1;
    private float posicionAnteriorY =-1;
     private Player player;
    private TextureAtlas atlas;
   // private Dialogs dialogs;
    //private StatusText statusText;
    private FabricaCharacter gestor = new FabricaCharacter();
    private int actual = 0;
    GestorDecorador gestorDecorador = new GestorDecorador();

    ShapeRenderer border;

    public RoomDelTiempo() {
        input = new Inputs();
        screen = new Pantalla("rooms/city/RoomDelTiempo.tmx");
        ///this.statusText = new StatusText(true);
        Resources.CURRENT_LOCATION = "City";
        int[] layers = {1, 3};
        atlas = new TextureAtlas("makecharacter/Pack/playerAssets.pack");
        player = new Player(atlas, 417, 350, this.screen.getWorld());
        screen.getWorld().setContactListener(new WorldContactListener());
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.input);
        this.rectangle=new Texture("rectangulo.png");

    }

    @Override
    public void render(float delta) {
        render.clearScreen();

       screen.update(delta);
       player.update(delta);

        render.Batch.setProjectionMatrix(screen.getCAMERA().combined);
        render.Batch.begin();
        //this.statusText.draw();

        player.draw(render.Batch);
        if (!Objects.equals(Resources.dialog, "")) {
            //this.dialogs.setText(Resources.dialog);
            //this.dialogs.draw();
        }
        render.Batch.end();
        //---------------
        inputHandler();


    }

    @Override
    public void resize(int width, int height) {screen.resize(width, height);}

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {dispose();
    }

    @Override
    public void dispose() {
        screen.isDispose(true);

        atlas.dispose();

    }


    private void inputHandler() {
        MapLayer mapLayer;
        mapLayer = screen.MAP.getLayers().get("Colisiones");

        MapObjects colisiones;
        colisiones = mapLayer.getObjects();
        if (posicionAnteriorX == -1){
            posicionAnteriorX = player.getX();
            posicionAnteriorY = player.getY();
        }

        if (input.isUp() || input.isDown() || input.isRight() || input.isLeft() || input.isEnter()) {
            boolean colisionArriba = false;
            boolean colisionAbajo = false;
            boolean colisionDerecha = false;
            boolean colisionIzquierda = false;

            MyRectangle playerMyRectangle =  new MyRectangleAdapter(player.getBoundingRectangle(), "player");

            boolean colisionConSalidaIzquierda = false;
            boolean colisionConSalidaDerecha = false;
            for (RectangleMapObject rectangle : colisiones.getByType(RectangleMapObject.class)) {
                MyRectangle paredMyRectangle = new MyRectangleAdapter(rectangle.getRectangle(), rectangle.getName());
                Colision ladoColision = gestorDecorador.getColision(playerMyRectangle, paredMyRectangle);
                if (ladoColision.colision()) {
                    System.out.println("Revisando colisiones de " + playerMyRectangle.getName() + " con " + paredMyRectangle.getName() + " = " + ladoColision);
                    if (paredMyRectangle.getName().equalsIgnoreCase("entradaSiguiente")){
                        Resources.MAIN.setScreen(new RoomMazmorra());

                    } else if(rectangle.getName().equalsIgnoreCase("entradaAnterior")){
                        System.out.println(paredMyRectangle.getName());
                    }
                }
                colisionArriba = colisionArriba || ladoColision.colisionArriba();
                colisionAbajo = colisionAbajo || ladoColision.colisionAbajo();
                colisionDerecha = colisionDerecha || ladoColision.colisionDerecha();
                colisionIzquierda = colisionIzquierda || ladoColision.colisionIzquierda();




            }

            if (input.isDown() && !colisionAbajo) {
                player.move("down");
            } else {
                if (input.isLeft() && !colisionIzquierda) {
                    player.move("left");
                } else {
                    if (input.isRight() && !colisionDerecha) {
                        player.move("right");
                    } else {
                        if (input.isUp() && !colisionArriba) {
                            player.move("up");
                        } else {
                            if (input.isEnter()) {
                                Resources.dialog = "";
                            } else{
                                player.move("none");
                            }
                        }
                    }
                }
            }
        }else {
            player.move("none");
        }

    }
}// Termina RoomMountain
