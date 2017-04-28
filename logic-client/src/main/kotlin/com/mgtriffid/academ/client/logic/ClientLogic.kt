package com.mgtriffid.academ.client.logic

/**
 * The whole client logic except loop and output is here.
 */
interface ClientLogic {

    /**
     * Basic iteration step. When called, the whole game state is iterated based on player's input, AI, game server
     * commands and whatever else.
     */
    fun tick()

    /**
     * This is where the whole initialisation of client logic is performed. Likely, this is not needed at all.
     * TODO: consider removing.
     */
    fun start()

    /**
     * Returns what player should see.
     *
     * @return The state to be rendered on output devices, including screen, speakers, etc.
     */
    fun state() : DrawableState
}