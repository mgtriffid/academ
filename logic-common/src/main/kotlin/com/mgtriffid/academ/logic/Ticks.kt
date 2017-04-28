package com.mgtriffid.academ.logic

/**
 * For tick-based game regulates update rate of game state and helps to render smoothly.
 */
interface Ticks {
    /**
     * Returns `true` if thinks it's already time to update the game state. If one invocation returned `true` and [tick] was
     * not call prior to next invocation, that next invocation should return `true` as well.
     */
    fun needUpdate(): Boolean

    /**
     * Call this after you have updated your game state.
     */
    fun tick()

    /**
     * Returns number between 0 and 1 representing the position of current time moment between previous tick boundary
     * and next one. This may be useful for smooth rendering, when state update rate is less than frame update, or for
     * lag compensation of hit-scan weapon in fast-paced shooter, or for other interpolations you can think of.
     */
    fun alpha(): Float

    /**
     * This method is here by mistake and because of poor design of server part.
     */
    fun toNextTickMillis(): Long //TODO: this is likely redundant

    class Fake : Ticks {
        override fun needUpdate() = true

        override fun tick() {}

        override fun alpha() = 0.5f

        override fun toNextTickMillis() = 10L
    }
}