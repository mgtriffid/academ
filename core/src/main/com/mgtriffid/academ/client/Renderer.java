package com.mgtriffid.academ.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mgtriffid.academ.client.logic.ClientLogic;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class Renderer {
    private SpriteBatch batch;
    private Texture img;

    Renderer() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
    }

    public void render(ClientLogic logic, float alpha) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
