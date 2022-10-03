package com.bisoft.game.menucharacter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.bisoft.game.Inputs.Inputs;
import com.bisoft.game.elements.Images;
import com.bisoft.game.elements.Text;
import com.bisoft.game.utils.Render;
import com.bisoft.game.utils.Resources;

import java.util.ArrayList;

public class CreateCharacterScreen implements Screen {
    private Render render;
    private Inputs input;
    //private Pantalla screen;

    private Texture guerrero, mago, mercenario;

    private Text titulo;

    private ArrayList<Text> options;
    private Images image;

    //private FabricaCharacter gestorCharacter;

    //private GestorPrototipo gestorPrototipo;

    //private int actual = 0;

    public CreateCharacterScreen() {

        input = new Inputs();
        guerrero = new Texture("assets/makecharacter/Guerrero/Guerro.png");
        mercenario = new Texture("assets/makecharacter/Mercenario/Mercenario.png");
        mago = new Texture("assets/makecharacter/Mago/Mago.png");
        image = new Images(Resources.CREATE_CHARACTER_BACKGROUND);
        titulo = new Text(Resources.GAME_FONT, 160, 450, 40, "Seleccione un Personaje");
        options = new ArrayList<>();
        //gestorCharacter = new FabricaCharacter();
        //gestorPrototipo = new GestorPrototipo(0, 0, 0, 0);
    }

    @Override
    public void show() {
        generateMenu();
        Gdx.input.setInputProcessor(input);

    }

    @Override
    public void render(float delta) {
        render.clearScreen();
        render.Batch.begin();
        image.draw();
        titulo.draw();
        for (Text mText : this.options) {
            mText.draw();
        }
        render.Batch.draw(guerrero, 150, 250);
        render.Batch.draw(mercenario, 350, 250);
        render.Batch.draw(mago, 550, 250);
        render.Batch.end();
        //validateKeys();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
    }
    private void generateMenu() {
        int mFontSize = 25;

        this.options.add(new Text("Guerrero", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Mercenario", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Mago", mFontSize, Resources.GAME_FONT));

        for (int i = 0; i < options.size(); i++) {

            if (i == 0) {
                this.options.get(i).setX(140);
            }
            if (i == 1) {
                this.options.get(1).setX(330);
            }
            if (i == 2) {
                this.options.get(2).setX(560);
            }
            this.options.get(i).setY(200);

        }


       // changeOptionColor(0);
    }






}