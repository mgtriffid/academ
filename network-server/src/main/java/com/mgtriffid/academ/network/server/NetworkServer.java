package com.mgtriffid.academ.network.server;

import com.esotericsoftware.kryonet.Server;

import java.io.IOException;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class NetworkServer {

    Server server;

    public void start() throws IOException {
        server = new Server();
        server.start();
        server.bind(54555, 54777);

    }
}
