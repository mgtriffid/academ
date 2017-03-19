package com.mgtriffid.academ.server.logic;

import com.mgtriffid.academ.network.common.CommandsChannel;
import com.mgtriffid.academ.network.common.commands.ClientCommand;
import com.mgtriffid.academ.network.server.NetworkServer;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class ServerLogic {
    NetworkServer server;
    ServerCommandsBuffer commandsBuffer = new ServerCommandsBuffer();

    ServerWorldStates worldStates;

    public ServerLogic(NetworkServer server) {
        this.server = server;
    }

    public void tick() {
        commandsBuffer.addAllCommands(server.provideCommandsChannel().fetchCommands());
    }
}
