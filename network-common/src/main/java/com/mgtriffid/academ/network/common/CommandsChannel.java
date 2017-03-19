package com.mgtriffid.academ.network.common;

import com.mgtriffid.academ.network.common.commands.meta.EnterGameCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class CommandsChannel<T> {
    public List<T> fetchCommands() {
        return new ArrayList<>();
    }

    public void push(T command) {

    }
}
