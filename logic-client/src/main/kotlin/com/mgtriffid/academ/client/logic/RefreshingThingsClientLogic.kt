package com.mgtriffid.academ.client.logic

/**
 * Decorates an instance of [ClientLogic] with ability to do some preparations right before each tick.
 * @param refresh function representing necessary preparations
 * @param logic decorated instance of [ClientLogic]
 */
class RefreshingThingsClientLogic(
        val refresh: () -> Unit,
        val logic: ClientLogic
) : ClientLogic by logic {
    override fun tick() {
        refresh()
        logic.tick()
    }
}