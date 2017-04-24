package com.mgtriffid.academ.network.client

import com.mgtriffid.academ.logic.WorldState

/**
 * Created by mgtriffid on 17.04.17.
 */
class StatesReceived(private val states: List<Pair<Int, WorldState>>) {

    fun states(): List<Pair<Int, WorldState>> {
        return states
    }
}
