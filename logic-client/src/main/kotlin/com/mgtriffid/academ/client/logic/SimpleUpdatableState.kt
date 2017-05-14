package com.mgtriffid.academ.client.logic

/**
 * Created by mgtriffid on 30.04.17.
 */
class SimpleUpdatableState(
        val world: World,
        val commands: Commands
) : UpdatableState {
    override fun update() {
        world.update(commands.current())
    }
}