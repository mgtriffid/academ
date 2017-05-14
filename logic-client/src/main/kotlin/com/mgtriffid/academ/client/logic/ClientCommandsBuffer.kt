package com.mgtriffid.academ.client.logic

import com.mgtriffid.academ.logic.WorldState
import com.mgtriffid.academ.client.logic.ClientCommandsChannel
import com.mgtriffid.academ.network.client.CommandsReceived
import com.mgtriffid.academ.network.client.NetworkClient
import com.mgtriffid.academ.network.client.StatesReceived
import com.mgtriffid.academ.network.common.commands.ConnectionCommand

/**
 * Created by mgtriffid on 19.03.17.
 */
class ClientCommandsBuffer(
        private val source: CommandsSource
) : CommandsBuffer {

    /**
     * Actually buffers things. Needs to be called every tick to work properly, otherwise, you may get outdated state.
     */
    fun refresh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun commands(tick: Int): CommandsSample {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun latestTickAvailable(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
