package com.mgtriffid.academ.client.logic

/**
 * Represents mode of network game. Can be buffering, running, starting, awaiting game state, and so on.
 * This is now a stub for design, so TODO: rethink, find proper place, proper name.
 */
interface GameMode {

    /**
     * Returns `true` if game is now running and should be properly iterated, `false` otherwise.
     */
    fun isRunning(): Boolean

    /**
     * Returns something that can be shown to player while game is buffering incoming packets, or starting, or anything
     * else.
     */
    fun splash(): DrawableState
}