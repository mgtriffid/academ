package com.mgtriffid.academ.client.logic;

import com.mgtriffid.academ.logic.WorldState;
import com.mgtriffid.academ.network.client.NetworkClient;
import com.mgtriffid.academ.network.common.commands.ConnectionCommand;
import com.mgtriffid.academ.network.common.Convert;
import com.mgtriffid.academ.network.common.TransferredState;
import com.mgtriffid.academ.network.common.commands.meta.EnterGameCommand;
import org.apache.commons.lang3.tuple.Pair;
import org.pmw.tinylog.Logger;

import static com.mgtriffid.academ.client.logic.ClientLogic.State.*;
import static com.mgtriffid.academ.network.common.commands.ConnectionCommand.Type.CONNECTION_ALLOWED;
import static com.mgtriffid.academ.network.common.commands.ConnectionCommand.Type.CONNECTION_PERMITTED;
import static com.mgtriffid.academ.network.common.Convert.toDto;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class ClientLogic {
    private NetworkClient client;
    private State state;
    private ClientCommandsBuffer clientCommandsBuffer = new ClientCommandsBuffer();
    private ClientWorldStates clientWorldStates = new ClientWorldStates();

    private int currentTick = -1;

    public void tick() {
        consumeServerCommands();
        doTick();
    }

    private void doTick() {
        Logger.info("State {}", state);
        if (state == CONNECTING) {
            for (ConnectionCommand connectionCommand : clientCommandsBuffer.getConnectionCommands()) {
                if (connectionCommand.type == CONNECTION_ALLOWED) {
                    state = AWAITING_GAMESTATE;
                }
                if (connectionCommand.type == CONNECTION_PERMITTED) {
                    //TODO: handle
                }
            }
        }
        if (state == AWAITING_GAMESTATE) {
            if (clientCommandsBuffer.initialStateReceived()) {
                Pair<Integer, WorldState> tickAndState = clientCommandsBuffer.getInitialState();
                currentTick = tickAndState.getLeft();
                fillCurrentStateFrom(tickAndState.getRight());
                state = BUFFERING;
            }
        }
        if ((state == BUFFERING) && enoughTicksToStartSimulation()) {
            state = RUNNING;
        }
        if (state == RUNNING) {
            WorldState nextWorldState = iterateGameState(clientWorldStates.get(currentTick));
            currentTick++;
            clientWorldStates.put(currentTick, nextWorldState);
        }
    }

    private WorldState iterateGameState(WorldState worldState) {
        return null;
    }

    private boolean enoughTicksToStartSimulation() {
        return clientCommandsBuffer.lastTick() > currentTick + 3; //TODO: make it smarter
    }

    private void fillCurrentStateFrom(WorldState state) {
        clientWorldStates.put(currentTick % 256, (state));
    }

    private void consumeServerCommands() {
        clientCommandsBuffer.addAllCommands(client.provideCommandsChannel().fetchCommands());
        clientCommandsBuffer.addAllStates(client.provideCommandsChannel().fetchStates());
    }

    public ClientLogic(NetworkClient client) {
        this.client = client;
        state = IDLE;
    }

    public void start() {
        if (state != IDLE) {
            throw new IllegalStateException("Can't start what is not in IDLE state");
        }
        sendEnterGameRequest();
        state = CONNECTING;
    }

    private void sendEnterGameRequest() {
        client.send(new EnterGameCommand());
    }

    enum State {
        IDLE,
        CONNECTING,
        AWAITING_GAMESTATE,
        BUFFERING,
        RUNNING
    }
}
