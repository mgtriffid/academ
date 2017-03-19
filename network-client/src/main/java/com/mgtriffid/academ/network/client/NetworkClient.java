package com.mgtriffid.academ.network.client;

import com.esotericsoftware.kryonet.Client;
import com.mgtriffid.academ.network.common.Convert;
import com.mgtriffid.academ.network.common.PlayerCommand;

import java.io.IOException;

import static com.mgtriffid.academ.network.common.NetworkCommon.registerDtos;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class NetworkClient {

    private Client client;
    private CommandsChannel commandsChannel = new CommandsChannel();

    public void sendCommands(PlayerCommand command) {
        //client.sendUDP(Convert.toDto(command));
    }

    public CommandsChannel provideCommandsChannel() {
        return commandsChannel;
    }

    public void start() {
        client = new Client();
        registerDtos(client.getKryo());
        client.addListener(new AcademClientListener(commandsChannel));
        client.start();
        try {
            client.connect(5000, "127.0.0.1", 54555, 54777);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
