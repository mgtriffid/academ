package com.mgtriffid.academ.client.logic.impl

import com.esotericsoftware.kryonet.Client
import com.esotericsoftware.kryonet.Listener
import com.mgtriffid.academ.client.logic.AcademClientListener
//import com.mgtriffid.academ.network.client.ClientCommandsChannel
import com.mgtriffid.academ.network.client.NetworkClient
import com.mgtriffid.academ.network.common.Convert
import com.mgtriffid.academ.network.common.PlayerCommand
import com.mgtriffid.academ.network.common.commands.meta.EnterGameCommand

import java.io.IOException

import com.mgtriffid.academ.network.common.NetworkCommon.registerDtos

/**
 * Created by mgtriffid on 19.03.17.
 */
class KryoNetworkClient(
        val listener: Listener
) : NetworkClient {

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private var client: Client? = null
//    private val commandsChannel = ClientCommandsChannel()

    override fun send(enterGameCommand: EnterGameCommand) {
        client!!.sendUDP(Convert.toDto(enterGameCommand))
    }

//    override fun commandsBuffer(): ClientCommandsChannel {
//        return commandsChannel
//    }

//    override fun start() {
//        client = Client()
//        registerDtos(client!!.kryo)
//        client!!.addListener(AcademClientListener(commandsChannel))
//        client!!.start()
//        try {
//            client!!.connect(5000, "127.0.0.1", 54555, 54777)
//        } catch (e: IOException) {
//            throw RuntimeException(e)
//        }
//
//    }

    override fun send(command: PlayerCommand) {
        //        TODO
    }
}
