package com.mgtriffid.academ.client.impl

import com.mgtriffid.academ.client.GameClient
import com.mgtriffid.academ.client.Graphics
import com.mgtriffid.academ.client.logic.ClientLogic
import com.mgtriffid.academ.logic.Ticks

/**
 * Created by mgtriffid on 17.04.17.
 */
class GameClientImpl (
        val ticks: Ticks,
        val logic: ClientLogic,
        val graphics: Graphics
) : GameClient {
    override fun start() {
        logic.start()
    }

    override fun progress() {
        while (ticks.needUpdate()) {
            logic.tick()
            ticks.tick()
        }
        graphics.render(logic, ticks.alpha()) //TODO: questionable
    }

    override fun dispose() {
        graphics.dispose()
    }
}