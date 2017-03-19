package com.mgtriffid.academ.network.client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.mgtriffid.academ.network.common.CommandsChannel;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class AcademClientListener extends Listener {

    CommandsChannel<ServerCommand> commandsChannel;

    public AcademClientListener(CommandsChannel<ServerCommand> commandsChannel) {
        this.commandsChannel = commandsChannel;
    }

    @Override
    public void received(Connection connection, Object object) {
        super.received(connection, object);
    }
}
