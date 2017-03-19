package com.mgtriffid.academ.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.mgtriffid.academ.client.logic.ClientLogic;
import com.mgtriffid.academ.logic.LoopOverseer;
import com.mgtriffid.academ.network.client.NetworkClient;

public class AcademLauncher extends ApplicationAdapter {
	private Renderer renderer;
	private NetworkClient client;
	private ClientLogic logic;
    private LoopOverseer overseer;
    private GameInput input;

    @Override
    public void create() {
        renderer = new Renderer();
        client = new NetworkClient();
        client.start();
        logic = new ClientLogic(client);
        overseer = new LoopOverseer();
        input = new GameInput();
        overseer.start();
        logic.start();
    }

    /**
     * This is kind of body of "main loop" from point of view of LibGDX.
     */
    @Override
    public void render() {
        input.collect();
        while (overseer.needUpdate()) {
//            client.send(input.playerCommand());
            logic.tick();
            overseer.tick();
        }
        renderer.render(logic, overseer.alpha());
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

}
