package com.mgtriffid.academ.network.client

import com.mgtriffid.academ.network.common.commands.ConnectionCommand
import com.mgtriffid.academ.network.common.commands.GameLogicCommands

/**
 * Created by mgtriffid on 31.03.17.
 */
class CommandsReceived(
        val connectionCommands: List<ConnectionCommand>,
        val gameLogicCommands: List<Pair<Int, GameLogicCommands>>
)
