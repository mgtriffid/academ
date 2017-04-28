package com.mgtriffid.academ.network.client;

import com.mgtriffid.academ.network.common.PlayerCommand;
import com.mgtriffid.academ.network.common.commands.meta.EnterGameCommand;
import org.jetbrains.annotations.NotNull;

/**
 * Created by mgtriffid on 17.04.17.
 */
public interface NetworkClient {
    void send(EnterGameCommand enterGameCommand);

    ClientCommandsChannel commandsBuffer();

    void start();

    void send(@NotNull PlayerCommand command);
}
