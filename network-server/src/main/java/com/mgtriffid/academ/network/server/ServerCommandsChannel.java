package com.mgtriffid.academ.network.server;

import com.mgtriffid.academ.network.common.commands.ClientCommand;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class ServerCommandsChannel {
    private BlockingQueue<Pair<ClientCommand, Integer>> queue = new LinkedBlockingQueue<>();

    public List<Pair<ClientCommand, Integer>> fetchCommands() {
        List<Pair<ClientCommand, Integer>> result = new ArrayList<>();
        queue.drainTo(result);
        return result;
    }

    /**
     * Pushes command to commands channel so that it can be safely retrieved from it in logic thread.
     * @param command - The command to push
     * @param connectionId - id of connection this command came from. Helps to identify player.
     */
    public void push(ClientCommand command, int connectionId) {
        queue.add(Pair.of(command, connectionId));
    }
}
