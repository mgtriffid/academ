package com.mgtriffid.academ.client.logic

import com.mgtriffid.academ.logic.Ticks

/**
 * Created by mgtriffid on 01.05.17.
 */
class NetworkCommands(
        val buffer: CommandsBuffer,
        val ticks: Ticks
) : Commands {
    override fun current(): CommandsSample {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}