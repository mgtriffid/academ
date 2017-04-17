package com.mgtriffid.academ.network.client;

import com.mgtriffid.academ.logic.WorldState;
import com.mgtriffid.academ.network.common.commands.ClientCommand;
import com.mgtriffid.academ.network.common.commands.ConnectionCommand;
import com.mgtriffid.academ.network.common.commands.GameLogicCommands;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by mgtriffid on 31.03.17.
 */
public class ClientCommandsChannel {

    private BlockingQueue<ConnectionCommand> connectionCommands = new LinkedBlockingQueue<>();

    public void pushConnectionCommand(ConnectionCommand command) {
        connectionCommands.add(command);
    }

    private BlockingQueue<Pair<Integer, WorldState>> states = new LinkedBlockingQueue<>();

    public CommandsReceived fetchCommands() {
        List<ConnectionCommand> connectionCommands = new ArrayList<>();
        this.connectionCommands.drainTo(connectionCommands);
        return new CommandsReceived(connectionCommands);
    }

    public StatesReceived fetchStates() {
        List<Pair<Integer, WorldState>> states = new ArrayList<>();
        this.states.drainTo(states);
        return new StatesReceived(states);
    }

    public void pushState(int tick, WorldState state) {
        states.add(Pair.of(tick, state));
    }

    public void push(int tick, GameLogicCommands gameLogicCommands) {
        //todo
    }
}
