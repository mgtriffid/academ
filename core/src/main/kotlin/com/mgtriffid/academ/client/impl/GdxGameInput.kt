package com.mgtriffid.academ.client.impl

import com.mgtriffid.academ.client.logic.GameInput
import com.mgtriffid.academ.network.common.PlayerCommand

/**
 * Gdx-based implementation of [GameInput].
 *
 * Uses LibGDX's built-in system to collect command based on input coming from devices.
 */
class GdxGameInput : GameInput {
    override fun snap() {

    }

    override fun command() : PlayerCommand {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}