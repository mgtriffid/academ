package com.mgtriffid.academ.network.common;

import com.esotericsoftware.kryo.Kryo;
import com.mgtriffid.academ.network.common.commands.ConnectionCommand;
import com.mgtriffid.academ.network.common.dto.ConnectionCommandDto;
import com.mgtriffid.academ.network.common.dto.WorldStateDto;
import com.mgtriffid.academ.network.common.dto.meta.EnterGameCommandDto;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class NetworkCommon {
    public static void registerDtos(Kryo kryo) {
        kryo.register(EnterGameCommandDto.class);
        kryo.register(ConnectionCommandDto.class);
        kryo.register(ConnectionCommandDto.Type.class);
        kryo.register(WorldStateDto.class);
    }
}
