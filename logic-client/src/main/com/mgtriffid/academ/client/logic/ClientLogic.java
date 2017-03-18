package com.mgtriffid.academ.client.logic;

import com.mgtriffid.academ.network.client.CommandsChannel;

import static com.mgtriffid.academ.client.logic.ClientLogic.State.CREATED;
import static com.mgtriffid.academ.client.logic.ClientLogic.State.RUNNING;
import static com.mgtriffid.academ.client.logic.ClientLogic.State.STARTING;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class ClientLogic {
    private State state;
    private CommandsChannel commandsChannel;
    private CommandsBuffer commandsBuffer = new CommandsBuffer();
    private ClientGameStates clientGameStates = new ClientGameStates();

    private int currentTick = -1;

    public void tick() {
        consumeServerCommands();
        if (state == STARTING) {
            if (mayBecomeRunning()) {
                state = RUNNING;
            }
        }
    }

    private void consumeServerCommands() {
        commandsBuffer.addAllCommands(commandsChannel.fetchCommands());
    }

    private boolean mayBecomeRunning() {
        return handshakeComplete() && commandsBuffer.lastTick() > currentTick + 3;
    }

    private boolean handshakeComplete() {
        return false;
    }

    public ClientLogic() {
        state = CREATED;
    }

    public void start() {
        if (state != CREATED) {
            throw new IllegalStateException("Can't start what is not in CREATED state");
        }
        state = STARTING;
    }

    public void setCommandsChannel(CommandsChannel commandsChannel) {
        this.commandsChannel = commandsChannel;
    }

    enum State {
        CREATED, STARTING, RUNNING
    }
}
