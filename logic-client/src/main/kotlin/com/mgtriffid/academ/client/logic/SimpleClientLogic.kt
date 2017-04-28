package com.mgtriffid.academ.client.logic

/**
 * Client logic not doing any client-side prediction.
 */
class SimpleClientLogic(
        val state: UpdatableState,
        val input: GameInput
) : ClientLogic {
    override fun tick() {
        input.snap()
        state.update()
    }

    override fun start() {

    }

    override fun state(): DrawableState {
        return state
    }
}