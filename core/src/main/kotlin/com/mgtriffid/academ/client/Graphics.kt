package com.mgtriffid.academ.client

import com.mgtriffid.academ.client.logic.ClientLogic
import com.mgtriffid.academ.client.logic.ClientLogicImpl

/**
 * Created by mgtriffid on 17.04.17.
 */
interface Graphics {
    fun render(logic: ClientLogic, alpha: Float)
    fun dispose()
}