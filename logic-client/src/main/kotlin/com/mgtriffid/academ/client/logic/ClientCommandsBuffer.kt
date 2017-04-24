package com.mgtriffid.academ.client.logic

import com.mgtriffid.academ.logic.WorldState
import com.mgtriffid.academ.network.client.ClientCommandsChannel
import com.mgtriffid.academ.network.client.CommandsReceived
import com.mgtriffid.academ.network.client.NetworkClient
import com.mgtriffid.academ.network.client.StatesReceived
import com.mgtriffid.academ.network.common.commands.ConnectionCommand

/**
 * Created by mgtriffid on 19.03.17.
 */
class ClientCommandsBuffer(private val channel: ClientCommandsChannel) {

    constructor(network: NetworkClient) : this(network.commandsBuffer())

    lateinit var connectionCommands: List<ConnectionCommand>
        private set
    private var states: List<Pair<Int, WorldState>>? = null

    fun lastTick(): Int {
        return 0
    }

    fun addAllCommands(serverCommands: CommandsReceived) {
        this.connectionCommands = serverCommands.connectionCommands //todo: this should be queue probably

    }

    fun initialStateReceived(): Boolean {
        return states != null && !states!!.isEmpty()
    }

    val initialState: Pair<Int, WorldState>
        get() = states!![0]

    fun addAllStates(statesReceived: StatesReceived) {
        this.states = statesReceived.states()
    }

    fun consumeCommands() {
        addAllCommands(channel.fetchCommands())
        addAllStates(channel.fetchStates())
    }
}
