package com.mgtriffid.academ.network.common;

import com.mgtriffid.academ.logic.WorldState;
import com.mgtriffid.academ.network.common.commands.meta.EnterGameCommand;
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

    public static WorldState toGameState(TransferredState initialState) {
        return null;
    }
}
