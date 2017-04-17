package com.mgtriffid.academ.network.common;

import com.mgtriffid.academ.logic.WorldState;
import com.mgtriffid.academ.network.common.commands.ConnectionCommand;
import com.mgtriffid.academ.network.common.commands.GameLogicCommands;
import com.mgtriffid.academ.network.common.commands.meta.EnterGameCommand;
import com.mgtriffid.academ.network.common.dto.ConnectionCommandDto;
import com.mgtriffid.academ.network.common.dto.WorldStateDto;
import com.mgtriffid.academ.network.common.dto.commands.GameLogicCommandsDto;
import com.mgtriffid.academ.network.common.dto.meta.EnterGameCommandDto;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class Convert {
    public static Object toDto(PlayerCommand command) {
        return null;
    }

    public static EnterGameCommandDto toDto(EnterGameCommand request) {
        return new EnterGameCommandDto();
    }

    public static EnterGameCommand fromDto(EnterGameCommandDto dto) {
        return new EnterGameCommand();
    }

    public static ConnectionCommand fromDto(ConnectionCommandDto object) {
        return new ConnectionCommand(object.getType().toRealType());
    }

    public static WorldStateDto toDto(int tick, WorldState state) {
        return new WorldStateDto();
    }

    public static WorldState fromDto(WorldStateDto dto) {
        return new WorldState();
    }

    public static GameLogicCommands fromDto(GameLogicCommandsDto commands) {
        return null; //TODO
    }
}
