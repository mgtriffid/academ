package com.mgtriffid.academ.client.logic

import com.mgtriffid.academ.network.client.NetworkClient

//TODO: Find proper place for this.

/**
 * Network-aware decorator for [GameInput].
 *
 * On each call of [snap] this sends the command issued by server via network.
 *
 * @property input Underlying implementation of [GameInput].
 * @property network [NetworkClient] used to transmit issued commands.
 */
class NetworkGameInput(
        val input: GameInput,
        val network: NetworkClient
) : GameInput by input {

    override fun snap() {
        input.snap()
        network.send(input.command())
    }
}