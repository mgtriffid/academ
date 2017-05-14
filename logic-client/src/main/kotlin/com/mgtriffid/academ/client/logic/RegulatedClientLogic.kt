package com.mgtriffid.academ.client.logic

/**
 * Created by mgtriffid on 29.04.17.
 */
class RegulatedClientLogic(
        val mode: GameMode,
        val logic: ClientLogic
) : ClientLogic by logic {

    override fun tick() {
        if (mode.isRunning()) {
            logic.tick()
        }
    }

    override fun state() = if (mode.isRunning()) logic.state() else mode.splash()
}