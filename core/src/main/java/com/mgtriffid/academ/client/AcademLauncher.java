package com.mgtriffid.academ.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.mgtriffid.academ.client.logic.ClientLogic;
import com.mgtriffid.academ.logic.Ticks;
import com.mgtriffid.academ.network.client.NetworkClient;

public class AcademLauncher extends ApplicationAdapter {
	private Graphics graphics;
	private NetworkClient client;
	private ClientLogic logic;
    private Ticks ticks;
    private GameInput input;

    @Override
    public void create() {
        graphics = new Graphics();
        client = new NetworkClient();
        client.start();
        logic = new ClientLogic(client);
        ticks = new Ticks();
        input = new GameInput();
        ticks.start();
        logic.start();
    }

    /**
     * This is kind of body of "main loop" from point of view of LibGDX.
     */
    @Override
    public void render() {
        input.collect();
        while (ticks.needUpdate()) {
//            client.send(input.playerCommand());
            logic.tick();
            ticks.tick();
        }
        graphics.render(logic, ticks.alpha());
    }

    @Override
    public void dispose() {
        graphics.dispose();
    }

}
