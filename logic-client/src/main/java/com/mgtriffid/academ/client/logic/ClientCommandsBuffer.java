package com.mgtriffid.academ.client.logic;

import com.mgtriffid.academ.logic.WorldState;
import com.mgtriffid.academ.network.client.CommandsReceived;
import com.mgtriffid.academ.network.client.StatesReceived;
import com.mgtriffid.academ.network.common.commands.ConnectionCommand;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class ClientCommandsBuffer {
    private List<ConnectionCommand> connectionCommands;
    private List<Pair<Integer, WorldState>> states;

    public int lastTick() {
        return 0;
    }

    public void addAllCommands(CommandsReceived serverCommands) {
        this.connectionCommands = serverCommands.getConnectionCommands();
    }

    public List<ConnectionCommand> getConnectionCommands() {
        return this.connectionCommands;
    }

    public boolean initialStateReceived() {
        return states != null && !states.isEmpty();
    }

    public Pair<Integer, WorldState> getInitialState() {
        return states.get(0);
    }

    public void addAllStates(StatesReceived statesReceived) {
        this.states = statesReceived.states();
    }
}
