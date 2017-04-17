package com.mgtriffid.academ.network.client;

import com.mgtriffid.academ.network.common.commands.ConnectionCommand;

import java.util.List;

/**
 * Created by mgtriffid on 31.03.17.
 */
public class CommandsReceived {
    private final List<ConnectionCommand> connectionCommands;

    public CommandsReceived(List<ConnectionCommand> connectionCommands) {
        this.connectionCommands = connectionCommands;
    }

    public List<ConnectionCommand> getConnectionCommands() {
        return connectionCommands;
    }
}
