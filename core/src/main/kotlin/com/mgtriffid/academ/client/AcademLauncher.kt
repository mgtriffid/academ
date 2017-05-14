package com.mgtriffid.academ.client

import com.badlogic.gdx.ApplicationAdapter
import com.mgtriffid.academ.client.impl.GameClientImpl
import com.mgtriffid.academ.client.impl.GdxGameInput
import com.mgtriffid.academ.client.impl.GdxGraphics
import com.mgtriffid.academ.client.logic.*
import com.mgtriffid.academ.config.AcademConfig
import com.mgtriffid.academ.logic.impl.SystemTicks
import com.mgtriffid.academ.client.logic.AcademClientListener
import com.mgtriffid.academ.network.client.NetworkClient
import com.mgtriffid.academ.client.logic.impl.KryoNetworkClient

class AcademLauncher : ApplicationAdapter() {
    lateinit var game: GameClientImpl

    override fun create() {
        val (sink, source) = CommandsChannel.Smart(ClientCommandsChannel()).ends()
        val network = KryoNetworkClient(
                AcademClientListener(
                        sink
                )
        )
        val ticks = SystemTicks(
                length = AcademConfig.tickLengthMillis
        )
        val buffer = ClientCommandsBuffer(
                source = source
        )
        game = GameClientImpl(
                ticks = ticks,
                logic = RefreshingThingsClientLogic(
                        { buffer.refresh() },
                        logic = RegulatedClientLogic(
                                mode = NetworkControlledGameMode(
                                        //TODO: what to inject? Maybe buffer?
                                ),
                                logic = SimpleClientLogic(
                                        state = SimpleUpdatableState(
                                                world = WorldImpl(),
                                                commands = NetworkCommands(
                                                        buffer = buffer,
                                                        ticks = ticks
                                                )
                                        ),
                                        input = NetworkGameInput(
                                                input = GdxGameInput(),
                                                network = network
                                        )
                                )
                        )
                ),
                graphics = GdxGraphics()
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
