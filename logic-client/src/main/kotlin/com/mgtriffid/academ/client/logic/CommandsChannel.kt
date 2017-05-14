package com.mgtriffid.academ.client.logic

/**
 * Represents channel required for communication between networking thread and game loop thread. Purely technical thing,
 * probably, with some implementations of networking this isn't be even needed.
 */
interface CommandsChannel {
    fun sink(): CommandsSink

    fun source(): CommandsSource

    class Smart(val channel: CommandsChannel) : CommandsChannel by channel {
        fun ends() = Pair(sink(), source())
    }
}