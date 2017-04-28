package com.mgtriffid.academ.client.logic

import com.mgtriffid.academ.network.common.PlayerCommand

/**
 * Represents input which comes from player at any given moment.
 */
interface GameInput {

    /**
     * Consumes actual game input. Call this to make next invocation of [command] return command that is
     * actually issued right now.
     */
    fun snap()

    /**
     * Returns command issued by player as of last invocation of [snap]. Implementations must assure to make this
     * method free of side effects - if [snap] was not called between two subsequent invocations, then their results
     * must be equal.
     */
    fun command(): PlayerCommand
}
