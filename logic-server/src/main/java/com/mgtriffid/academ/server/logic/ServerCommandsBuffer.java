package com.mgtriffid.academ.server.logic;

import com.google.common.collect.ImmutableMap;
import com.mgtriffid.academ.network.common.PlayerCommand;
import com.mgtriffid.academ.network.common.commands.ClientCommand;
import com.mgtriffid.academ.network.common.commands.meta.EnterGameCommand;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class ServerCommandsBuffer {

    private Map<Integer, EnterGameCommand> enterGameCommands = new HashMap<>();

    public void addAllCommands(List<Pair<ClientCommand, Integer>> clientCommands) {
        clientCommands.forEach(pair -> {
            ClientCommand command = pair.getLeft();
            if (command instanceof EnterGameCommand) {
                enterGameCommands.put(pair.getRight(), (EnterGameCommand) command);
            }
        });
    }

    public Map<Integer, EnterGameCommand> fetchEnterGameCommands() {
        ImmutableMap<Integer, EnterGameCommand> result = ImmutableMap.copyOf(enterGameCommands);
        enterGameCommands.clear();
        return result;
    }

    public Map<Integer, PlayerCommand> getPlayerCommands(int tick) {
        return Collections.emptyMap();
    }
}
