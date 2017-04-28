package com.mgtriffid.academ.network.client.impl;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Listener;
import com.mgtriffid.academ.network.client.AcademClientListener;
import com.mgtriffid.academ.network.client.ClientCommandsChannel;
import com.mgtriffid.academ.network.client.NetworkClient;
import com.mgtriffid.academ.network.common.Convert;
import com.mgtriffid.academ.network.common.PlayerCommand;
import com.mgtriffid.academ.network.common.commands.meta.EnterGameCommand;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import static com.mgtriffid.academ.network.common.NetworkCommon.registerDtos;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class KryoNetworkClient implements NetworkClient {

    private Client client;
    private ClientCommandsChannel commandsChannel = new ClientCommandsChannel();

    @Override public void send(EnterGameCommand enterGameCommand) {
        client.sendUDP(Convert.toDto(enterGameCommand));
    }

    @Override public ClientCommandsChannel commandsBuffer() {
        return commandsChannel;
    }

    @Override public void start() {
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

    @Override
    public void send(@NotNull PlayerCommand command) {
//        TODO
    }
}
