package com.mgtriffid.academ.network.client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class AcademClientListener extends Listener {

    CommandsChannel commandsChannel;

    public AcademClientListener(CommandsChannel commandsChannel) {
        this.commandsChannel = commandsChannel;
    }

    @Override
    public void received(Connection connection, Object object) {
        super.received(connection, object);
    }
}
