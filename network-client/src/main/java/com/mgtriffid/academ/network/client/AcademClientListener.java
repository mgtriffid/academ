package com.mgtriffid.academ.network.client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.mgtriffid.academ.logic.WorldState;
import com.mgtriffid.academ.network.common.Convert;
import com.mgtriffid.academ.network.common.commands.ConnectionCommand;
import com.mgtriffid.academ.network.common.dto.ConnectionCommandDto;
import com.mgtriffid.academ.network.common.dto.WorldStateDto;
import com.mgtriffid.academ.network.common.dto.commands.GameLogicCommandsDto;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class AcademClientListener extends Listener {

    ClientCommandsChannel commandsChannel;

    public AcademClientListener(ClientCommandsChannel commandsChannel) {
        this.commandsChannel = commandsChannel;
    }

    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof ConnectionCommandDto) {
            ConnectionCommand command = Convert.fromDto((ConnectionCommandDto) object);
            commandsChannel.pushConnectionCommand(command);
        } else if (object instanceof WorldStateDto) {
            WorldStateDto worldStateDto = (WorldStateDto) object;
            commandsChannel.pushState(worldStateDto.tick(), Convert.fromDto(worldStateDto));
        } else if (object instanceof GameLogicCommandsDto) {
            GameLogicCommandsDto commands = (GameLogicCommandsDto) object;
            commandsChannel.push(commands.tick(), Convert.fromDto(commands));
        }
        super.received(connection, object);
    }
}
