package com.mgtriffid.academ.client.logic;

import com.mgtriffid.academ.logic.WorldState;
import com.mgtriffid.academ.network.client.CommandsChannel;
import com.mgtriffid.academ.network.common.ConnectionCommand;
import com.mgtriffid.academ.network.common.Convert;
import com.mgtriffid.academ.network.common.TransferredState;

import static com.mgtriffid.academ.client.logic.ClientLogic.State.*;
import static com.mgtriffid.academ.network.common.ConnectionCommand.Type.CONNECTION_ALLOWED;
import static com.mgtriffid.academ.network.common.ConnectionCommand.Type.CONNECTION_PERMITTED;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class ClientLogic {
    private State state;
    private CommandsChannel commandsChannel;
    private CommandsBuffer commandsBuffer = new CommandsBuffer();
    private ClientWorldStates clientWorldStates = new ClientWorldStates();

    private int currentTick = -1;

    public void tick() {
        consumeServerCommands();
        doTick();
    }

    private void doTick() {
        if (state == CONNECTING) {
            for (ConnectionCommand connectionCommand : commandsBuffer.getConnectionCommands()) {
                if (connectionCommand.type == CONNECTION_ALLOWED) {
                    state = AWAITING_GAMESTATE;
                }
                if (connectionCommand.type == CONNECTION_PERMITTED) {
                    //TODO: handle
                }
            }
        }
        if (state == AWAITING_GAMESTATE) {
            if (commandsBuffer.initialStateReceived()) {
                TransferredState initialState = commandsBuffer.getInitialState();
                currentTick = initialState.getTick();
                fillCurrentStateFrom(initialState);
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
        return commandsBuffer.lastTick() > currentTick + 3;
    }

    private void fillCurrentStateFrom(TransferredState initialState) {
        clientWorldStates.put(currentTick % 256, Convert.toGameState(initialState));
    }

    private void consumeServerCommands() {
        commandsBuffer.addAllCommands(commandsChannel.fetchCommands());
    }

    public ClientLogic() {
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

    }

    public void setCommandsChannel(CommandsChannel commandsChannel) {
        this.commandsChannel = commandsChannel;
    }

    enum State {
        IDLE,
        CONNECTING,
        AWAITING_GAMESTATE,
        BUFFERING,
        RUNNING
    }
}
