package com.mgtriffid.academ.server.logic;

import com.mgtriffid.academ.logic.WorldState;
import com.mgtriffid.academ.network.common.PlayerCommand;
import com.mgtriffid.academ.network.common.commands.meta.EnterGameCommand;
import com.mgtriffid.academ.network.server.NetworkServer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class ServerLogic {
    NetworkServer server;
    ServerCommandsBuffer commandsBuffer = new ServerCommandsBuffer();
    int tick;

    Map<Integer, PlayerState> playerStates = new ConcurrentHashMap<>();
    ServerWorldStates worldStates = new ServerWorldStates();

    public ServerLogic(NetworkServer server) {
        this.server = server;
    }

    public void tick() {
        consumeClientsCommands();
        doTick();
    }

    private void doTick() {
        tick++;
        Map<Integer, EnterGameCommand> enterGameCommands = commandsBuffer.fetchEnterGameCommands();
        enterGameCommands.forEach((id, command) -> {
            playerStates.put(id, PlayerState.JOINING);
            server.sendConnectionAllowed(id);
        });

        Map<Integer, PlayerCommand> playerCommands = commandsBuffer.getPlayerCommands(tick);
        worldStates.put(tick, calculateState(playerCommands, worldStates.get(tick - 1)));
        playerStates.entrySet().stream().filter(entry -> entry.getValue() == PlayerState.JOINING).forEach(entry -> {
            server.sendState(entry.getKey(), tick, worldStates.get(tick));
        });
    }

    private WorldState calculateState(Map<Integer, PlayerCommand> playerCommands, WorldState state) {
        return new WorldState();
    }

    private void consumeClientsCommands() {
        commandsBuffer.addAllCommands(server.provideCommandsChannel().fetchCommands());
    }
}
