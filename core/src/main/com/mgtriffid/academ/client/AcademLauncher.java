package com.mgtriffid.academ.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.mgtriffid.academ.client.logic.ClientLogic;
import com.mgtriffid.academ.network.client.NetworkClient;

public class AcademLauncher extends ApplicationAdapter {
	private Renderer renderer;
	private NetworkClient client;
	private ClientLogic logic;
    private LoopOverseer overseer;
    private GameInput input;

    @Override
    public void create () {
        renderer = new Renderer();
        client = new NetworkClient();
        logic = new ClientLogic();
        logic.setCommandsChannel(client.provideCommandsChannel());
        overseer = new LoopOverseer();
        input = new GameInput();
        overseer.start();
        logic.start();
    }

    /**
     * This is kind of body of "main loop" from point of view of LibGDX.
     */
    @Override
    public void render () {
        input.collect();
        if (overseer.needUpdate()) {
            client.sendCommands(input.playerCommand());
            logic.tick();
        }
        renderer.render(logic, overseer.alpha());
    }

    @Override
    public void dispose () {
        renderer.dispose();
    }

}
