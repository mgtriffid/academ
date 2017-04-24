package com.mgtriffid.academ.logic

/**
 * Created by mgtriffid on 17.04.17.
 */
interface Ticks {
    fun needUpdate(): Boolean
    fun tick()
    fun alpha(): Float
    fun toNextTickMillis(): Long //TODO: this is likely redundant

    class Fake : Ticks {
        override fun needUpdate() = true

        override fun tick() {}

        override fun alpha() = 0.5f

        override fun toNextTickMillis() = 10L
    }
}