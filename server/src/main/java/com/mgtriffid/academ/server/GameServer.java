package com.mgtriffid.academ.server;

import com.mgtriffid.academ.network.server.NetworkServer;
import com.mgtriffid.academ.server.logic.ServerLogic;

import java.io.IOException;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class GameServer {
    NetworkServer server;
    ServerLogic logic;

    public static void main(String[] args) throws IOException {
        new GameServer().start();
    }

    GameServer() {
        logic = new ServerLogic();
        server = new NetworkServer();
    }

    private void start() throws IOException {
        server.start();
    }
}
