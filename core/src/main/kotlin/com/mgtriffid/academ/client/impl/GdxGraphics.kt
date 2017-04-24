package com.mgtriffid.academ.client.impl

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mgtriffid.academ.client.Graphics
import com.mgtriffid.academ.client.logic.ClientLogic
import com.mgtriffid.academ.client.logic.ClientLogicImpl

/**
 * Created by mgtriffid on 19.03.17.
 */
class GdxGraphics : Graphics {
    private val batch = SpriteBatch()
    private val img = Texture("badlogic.jpg")

    override fun render(logic: ClientLogic, alpha: Float) {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(img, 0f, 0f)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        img.dispose()
    }
}
