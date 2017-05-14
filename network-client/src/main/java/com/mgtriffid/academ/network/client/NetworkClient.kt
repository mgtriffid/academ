package com.mgtriffid.academ.network.client

import com.mgtriffid.academ.network.common.PlayerCommand
import com.mgtriffid.academ.network.common.commands.meta.EnterGameCommand

/**
 * Created by mgtriffid on 17.04.17.
 */
interface NetworkClient {
    fun send(enterGameCommand: EnterGameCommand)

    fun start()

    fun send(command: PlayerCommand)
}
