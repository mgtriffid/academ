package com.mgtriffid.academ.server;

import com.mgtriffid.academ.logic.Ticks;
import com.mgtriffid.academ.network.server.NetworkServer;
import com.mgtriffid.academ.server.logic.ServerLogic;

import java.io.IOException;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class GameServer {
    NetworkServer server;
    ServerLogic logic;
    Ticks overseer;

    public static void main(String[] args) throws IOException, InterruptedException {
        new GameServer().start();
    }

    GameServer() {
        server = new NetworkServer();
        logic = new ServerLogic(server);
        overseer = new Ticks();
    }

    private void start() throws IOException, InterruptedException {
        server.start();
        overseer.start();
        startLoop();
    }

    private void startLoop() throws InterruptedException {
        while (true) {
            server.dispatchCommands();
            logic.tick();
            overseer.tick();
            long toNextTickMillis = overseer.toNextTickMillis();
            if (toNextTickMillis > 0) Thread.sleep(toNextTickMillis);
        }
    }
}
