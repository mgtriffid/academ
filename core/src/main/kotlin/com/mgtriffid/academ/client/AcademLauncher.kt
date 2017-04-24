package com.mgtriffid.academ.client

import com.badlogic.gdx.ApplicationAdapter
import com.mgtriffid.academ.client.impl.GameClientImpl
import com.mgtriffid.academ.client.impl.GdxGameInput
import com.mgtriffid.academ.client.impl.GdxGraphics
import com.mgtriffid.academ.client.logic.ClientCommandsBuffer
import com.mgtriffid.academ.client.logic.ClientLogicImpl
import com.mgtriffid.academ.config.AcademConfig
import com.mgtriffid.academ.logic.impl.SystemTicks
import com.mgtriffid.academ.network.client.NetworkClient
import com.mgtriffid.academ.network.client.impl.KryoNetworkClient

class AcademLauncher : ApplicationAdapter() {
    lateinit var game: GameClientImpl

    override fun create() {
        val network = KryoNetworkClient()
        game = GameClientImpl(
                SystemTicks(
                        AcademConfig.tickLengthMillis
                ),
                ClientLogicImpl(
                        GdxGameInput(),
                        network,
                        ClientCommandsBuffer(network)
                ),
                GdxGraphics()
        )
        game.start()
    }

    /**
     * This is kind of body of "main loop" from point of view of LibGDX.
     */
    override fun render() {
        game.progress()
    }

    override fun dispose() {
        game.dispose()
    }

}
