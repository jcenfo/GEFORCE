package com.bisoft.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bisoft.game.Inputs.Inputs;
import com.bisoft.game.elements.Images;
import com.bisoft.game.elements.Text;
import com.bisoft.game.menucharacter.CreateCharacterScreen;
import com.bisoft.game.utils.Render;
import com.bisoft.game.utils.Resources;

public class Room2Screen implements Screen {
    private Images back;
    private Inputs input;

    private Text gameName;

    private int actual = 0;

    ShapeRenderer border;

    public Room2Screen() {
        this.back = new Images(Resources.ARCADE_ROOM);
        this.input = new Inputs();
        this.border = new ShapeRenderer();
        this.gameName = new Text(Resources.GAME_FONT, 200, 510, 80, "");
        resize(1000,1000);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float delta) {
        Render.Batch.begin();
        this.back.draw();
        this.gameName.draw();
        Render.Batch.end();
        /*validateMouse();*/
        //showLoreScreen();
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

    }

    @Override
    public void dispose() {

    }
}
