package com.mgtriffid.academ.client.logic

/**
 * Created by mgtriffid on 01.05.17.
 */
//TODO: find proper place for this - package, module, etc
//TODO: Can this be somehow collapsed with state?
interface World {
    fun  update(current: CommandsSample)
}