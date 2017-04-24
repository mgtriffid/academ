package com.mgtriffid.academ.client

/**
 * Created by mgtriffid on 17.04.17.
 */

interface GameClient {
    fun progress()
    fun dispose()

    class Fake : GameClient {
        override fun start() {}

        override fun progress() {}

        override fun dispose() {}
    }

    fun start()
}