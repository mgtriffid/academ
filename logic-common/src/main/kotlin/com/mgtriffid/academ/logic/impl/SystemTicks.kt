package com.mgtriffid.academ.logic.impl

import com.mgtriffid.academ.logic.Ticks

/**
 * Created by mgtriffid on 19.03.17.
 */
class SystemTicks (
        private val length: Long
) : Ticks {
    private var next: Long = now() + length

    override fun needUpdate() = next < now()

    override fun tick() {
        next += length
    }

    override fun alpha() = (1 - (next - now()).toFloat() / length.toFloat())

    override fun toNextTickMillis() = next - now()

    private fun now() = System.currentTimeMillis()
}
