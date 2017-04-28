package com.mgtriffid.academ.client

/**
 * The whole game client adopted for usage with LibGDX (but not necessarily).
 */
interface GameClient {

    /**
     * This should be called only once when game starts. Do necessary preparations here.
     * TODO: Is this really needed? Maybe the proper way to do this is to give all dependencies already started?
     */
    fun start()

    /**
     * This method should be called as frequently as possible. This should be the whole body of your main game loop, be
     * it actual loop or, for example, call of [com.badlogic.gdx.ApplicationListener.render] in case of LibGDX.
     */
    fun progress()

    /**
     * Final part of GameClient lifecycle. Close all the resources here.
     */
    fun dispose()

    class Fake : GameClient {
        override fun start() {}

        override fun progress() {}

        override fun dispose() {}
    }
}