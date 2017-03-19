package com.mgtriffid.academ.network.server;

import com.esotericsoftware.kryonet.Server;
import com.mgtriffid.academ.network.common.CommandsChannel;
import com.mgtriffid.academ.network.common.commands.ClientCommand;

import java.io.IOException;

import static com.mgtriffid.academ.network.common.NetworkCommon.registerDtos;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class NetworkServer {
    CommandsChannel<ClientCommand> commandsChannel = new CommandsChannel<>();

    Server server;

    public void start() throws IOException {
        server = new Server();
        registerDtos(server.getKryo());
        server.start();
        server.bind(54555, 54777);
        server.addListener(new AcademServerListener(commandsChannel));
    }

    public void dispatchCommands() {

    }

    public CommandsChannel<ClientCommand> provideCommandsChannel() {
        return commandsChannel;
    }
}
