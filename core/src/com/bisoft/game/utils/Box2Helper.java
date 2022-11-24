package com.bisoft.game.utils;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.bisoft.game.utils.InteractiveObjects.Mountain;

public class Box2Helper {
    private World WORLD;
    private Box2DDebugRenderer B2DR;

    private BodyDef BDEF;
    private PolygonShape SHAPE;
    private FixtureDef FDEF;
    private Body BODY;


    public World getWORLD() {
        return WORLD;
    }

    public Box2DDebugRenderer getB2DR() {
        return B2DR;
    }


    public Box2Helper(World pWorld) {
        WORLD = pWorld;
        B2DR = new Box2DDebugRenderer();
        B2DR.setDrawBodies(false);
        BDEF = new BodyDef();
        SHAPE = new PolygonShape();
        FDEF = new FixtureDef();

    }

    public void create2DBoxes(TiledMap pMap, int pIdLayer) {
        for (MapObject object : pMap.getLayers().get(pIdLayer).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            BDEF.type = BodyDef.BodyType.StaticBody;
            BDEF.position.set((rect.getX() + rect.getWidth() / 2), (rect.getY() + rect.getHeight() / 2));

            SHAPE.setAsBox((rect.getWidth() / 2), (rect.getHeight() / 2));

            FDEF.shape = SHAPE;


            BODY = WORLD.createBody(BDEF);
            BODY.createFixture(FDEF);

        }
    }

    public void MapaArcadeMejoraObject(TiledMap pMap, int pIdLayer) {
        for (MapObject object : pMap.getLayers().get(pIdLayer).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Mountain(WORLD, pMap, rect);

        }

    }




    public void dispose() {
        System.out.println(WORLD.getBodyCount());
        Array<Body> bodies = new Array<Body>(WORLD.getBodyCount());
        WORLD.getBodies(bodies);
        for (Body body : bodies) {
            WORLD.destroyBody(body);
        }
    }


}
