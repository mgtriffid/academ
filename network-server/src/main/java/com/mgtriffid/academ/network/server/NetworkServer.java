package com.mgtriffid.academ.network.server;

import com.esotericsoftware.kryonet.Server;
import com.mgtriffid.academ.logic.WorldState;
import com.mgtriffid.academ.network.common.Convert;
import com.mgtriffid.academ.network.common.commands.ConnectionCommand;
import com.mgtriffid.academ.network.common.dto.ConnectionCommandDto;

import java.io.IOException;

import static com.mgtriffid.academ.network.common.NetworkCommon.registerDtos;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class NetworkServer {
    ServerCommandsChannel commandsChannel = new ServerCommandsChannel();

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

    public ServerCommandsChannel provideCommandsChannel() {
        return commandsChannel;
    }

    public void sendState(int id, int tick, WorldState state) {
        server.sendToUDP(id, Convert.toDto(tick, state));
    }

    public void sendConnectionAllowed(Integer id) {
        ConnectionCommandDto commandDto = new ConnectionCommandDto();
        commandDto.setType(ConnectionCommandDto.Type.CONNECTION_ALLOWED);
        server.sendToUDP(id, commandDto);
    }
}
