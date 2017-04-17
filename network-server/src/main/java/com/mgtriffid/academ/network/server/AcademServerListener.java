package com.mgtriffid.academ.network.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.mgtriffid.academ.network.common.commands.ClientCommand;
import com.mgtriffid.academ.network.common.dto.meta.EnterGameCommandDto;

import static com.mgtriffid.academ.network.common.Convert.fromDto;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class AcademServerListener extends Listener {

    private final ServerCommandsChannel commandsChannel;

    public AcademServerListener(ServerCommandsChannel commandsChannel) {
        this.commandsChannel = commandsChannel;
    }

    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof EnterGameCommandDto) {
            commandsChannel.push(fromDto((EnterGameCommandDto) object), connection.getID());
        }
        super.received(connection, object);
    }
}
