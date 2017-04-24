package com.mgtriffid.academ.client.logic

import com.mgtriffid.academ.network.common.PlayerCommand

/**
 * Created by mgtriffid on 19.03.17.
 */
interface GameInput {
    fun collect()
    fun playerCommand(): PlayerCommand? //TODO: not null
}
