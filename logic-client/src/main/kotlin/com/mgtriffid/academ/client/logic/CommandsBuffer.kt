package com.mgtriffid.academ.client.logic

/**
 * Represents buffered commands which are stored on client. Buffering is technique used to eliminate issues with
 * unstable network, packet loss and floating latency.
 */
//TODO: find proper place for this - package, module, etc
interface CommandsBuffer {

    /**
     * @return number of latest tick for which commands are already available.
     */
    fun latestTickAvailable() : Int

    /**
     * Returns commands sample for given tick.
     */
    fun commands(tick: Int) : CommandsSample

}