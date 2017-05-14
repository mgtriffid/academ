package com.mgtriffid.academ.client.logic

import com.esotericsoftware.kryonet.Connection
import com.esotericsoftware.kryonet.Listener
import com.mgtriffid.academ.network.common.Convert
import com.mgtriffid.academ.network.common.commands.ConnectionCommand
import com.mgtriffid.academ.network.common.dto.ConnectionCommandDto
import com.mgtriffid.academ.network.common.dto.WorldStateDto
import com.mgtriffid.academ.network.common.dto.commands.GameLogicCommandsDto

/**
 * Created by mgtriffid on 19.03.17.
 */
class AcademClientListener(private val sink: CommandsSink) : Listener() {

    override fun received(connection: Connection?, `object`: Any?) {
        if (`object` is ConnectionCommandDto) {
            val command = Convert.fromDto(`object` as ConnectionCommandDto?)
//            commandsChannel.pushConnectionCommand(command)
        } else if (`object` is WorldStateDto) {
            val worldStateDto = `object`
//            commandsChannel.pushState(worldStateDto.tick(), Convert.fromDto(worldStateDto))
        } else if (`object` is GameLogicCommandsDto) {
            val commands = `object`
//            commandsChannel.push(commands.tick(), Convert.fromDto(commands))
        }
        super.received(connection, `object`)
    }
}
