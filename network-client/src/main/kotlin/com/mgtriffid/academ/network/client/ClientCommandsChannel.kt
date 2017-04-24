package com.mgtriffid.academ.network.client

import com.mgtriffid.academ.logic.WorldState
import com.mgtriffid.academ.network.common.commands.ConnectionCommand
import com.mgtriffid.academ.network.common.commands.GameLogicCommands

import java.util.ArrayList
import java.util.concurrent.LinkedBlockingQueue

/**
 * Created by mgtriffid on 31.03.17.
 */
class ClientCommandsChannel {

    private val connectionCommands = LinkedBlockingQueue<ConnectionCommand>()
    private val gameLogicCommands = LinkedBlockingQueue<Pair<Int, GameLogicCommands>>()

    fun pushConnectionCommand(command: ConnectionCommand) {
        connectionCommands.add(command)
    }
    //TODO: migrate to Kotlin pair
    private val states = LinkedBlockingQueue<Pair<Int, WorldState>>()

    fun fetchCommands(): CommandsReceived {
        val connectionCommands = ArrayList<ConnectionCommand>()
        this.connectionCommands.drainTo(connectionCommands)
        val gameLogicCommands = ArrayList<Pair<Int, GameLogicCommands>>()
        this.gameLogicCommands.drainTo(gameLogicCommands)
        return CommandsReceived(connectionCommands, gameLogicCommands)
    }

    fun fetchStates(): StatesReceived {
        val states = ArrayList<Pair<Int, WorldState>>()
        this.states.drainTo(states)
        return StatesReceived(states)
    }

    fun pushState(tick: Int, state: WorldState) {
        states.add(Pair(tick, state))
    }

    fun push(tick: Int, gameLogicCommands: GameLogicCommands) {
        this.gameLogicCommands.add(Pair(tick, gameLogicCommands))
    }
}
