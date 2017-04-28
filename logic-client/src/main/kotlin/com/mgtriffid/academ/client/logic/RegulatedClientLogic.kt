package com.mgtriffid.academ.client.logic

/**
 * Created by mgtriffid on 29.04.17.
 */
class RegulatedClientLogic(
        val logic: ClientLogic,
        val mode: GameMode
) : ClientLogic by logic {

    override fun tick() {
        if (mode.isRunning()) {
            logic.tick()
        }
    }

    override fun state() = if (mode.isRunning()) logic.state() else mode.splash()
}