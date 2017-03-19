package com.mgtriffid.academ.client.logic;

import com.mgtriffid.academ.network.client.ServerCommand;
import com.mgtriffid.academ.network.common.ConnectionCommand;
import com.mgtriffid.academ.network.common.TransferredState;

import java.util.Collections;
import java.util.List;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class ClientCommandsBuffer {
    public int lastTick() {
        return 0;
    }

    public void addAllCommands(List<ServerCommand> serverCommands) {

    }

    public List<ConnectionCommand> getConnectionCommands() {
        return Collections.emptyList();
    }

    public boolean initialStateReceived() {
        return false;
    }

    public TransferredState getInitialState() {
        return null;
    }
}
