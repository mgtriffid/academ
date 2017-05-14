package com.mgtriffid.academ.client.logic

import com.mgtriffid.academ.network.common.PlayerCommand

/**
 *
 */
//TODO: find proper place for this - package, module, etc
interface CommandsSink {
    fun send(command: PlayerCommand)
}