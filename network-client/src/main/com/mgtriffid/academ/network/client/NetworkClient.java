package com.mgtriffid.academ.network.client;

import com.esotericsoftware.kryonet.Client;
import com.mgtriffid.academ.network.common.PlayerCommand;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class NetworkClient {

    private Client client;
    private CommandsChannel commandsChannel = new CommandsChannel();

    public void sendCommands(PlayerCommand command) {

    }

    public CommandsChannel provideCommandsChannel() {
        return commandsChannel;
    }

}
