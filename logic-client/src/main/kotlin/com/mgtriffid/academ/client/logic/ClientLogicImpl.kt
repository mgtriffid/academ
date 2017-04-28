package com.mgtriffid.academ.client.logic

import com.mgtriffid.academ.logic.WorldState
import com.mgtriffid.academ.network.client.NetworkClient
import com.mgtriffid.academ.network.common.commands.meta.EnterGameCommand
import org.pmw.tinylog.Logger

import com.mgtriffid.academ.client.logic.ClientLogicImpl.State.*
import com.mgtriffid.academ.network.common.commands.ConnectionCommand.Type.CONNECTION_ALLOWED
import com.mgtriffid.academ.network.common.commands.ConnectionCommand.Type.CONNECTION_NOT_ALLOWED

/**
 * Created by mgtriffid on 19.03.17.
 */
class ClientLogicImpl(
        private val input: GameInput,
        private val client: NetworkClient,
        private val clientCommandsBuffer: ClientCommandsBuffer
) : ClientLogic {
    override fun state(): DrawableState {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var state: State? = null //TODO: nullability
    private val clientWorldStates = ClientWorldStates() //TODO: this should be probably injected

    private var currentTick = -1

    init {
        state = IDLE
    }

    override fun tick() {
        consumeServerCommands()
        doTick()
    }

    private fun doTick() {
        Logger.info("State {}", state)
        if (state == CONNECTING) {
            for (connectionCommand in clientCommandsBuffer.connectionCommands) {
                if (connectionCommand.type == CONNECTION_ALLOWED) {
                    state = AWAITING_GAMESTATE
                }
                if (connectionCommand.type == CONNECTION_NOT_ALLOWED) {
                    //TODO: handle
                }
            }
        }
        if (state == AWAITING_GAMESTATE) {
            if (clientCommandsBuffer.initialStateReceived()) {
                val (tick, worldState) = clientCommandsBuffer.initialState
                currentTick = tick
                fillCurrentStateFrom(worldState)
                state = BUFFERING
            }
        }
        if (state == BUFFERING && enoughTicksToStartSimulation()) {
            state = RUNNING
        }
        if (state == RUNNING) {
            val nextWorldState = iterateGameState(clientWorldStates.get(currentTick))
            currentTick++
            clientWorldStates.put(currentTick, nextWorldState)
        }
    }

    override fun start() {
        if (state != IDLE) {
            throw IllegalStateException("Can't start what is not in IDLE state")
        }
        client.start()
        sendEnterGameRequest()
        state = CONNECTING
    }

    private fun sendEnterGameRequest() {
        client.send(EnterGameCommand())
    }

    private fun enoughTicksToStartSimulation() = clientCommandsBuffer.lastTick() > currentTick + 3 //TODO: make it smarter

    private fun consumeServerCommands() {
        clientCommandsBuffer.consumeCommands()
    }

    private fun fillCurrentStateFrom(state: WorldState) {
        clientWorldStates.put(currentTick % 256, state)
    }

    private fun iterateGameState(worldState: WorldState?): WorldState? {
        return null
    }

    internal enum class State {
        IDLE,
        CONNECTING,
        AWAITING_GAMESTATE,
        BUFFERING,
        RUNNING
    }
}
