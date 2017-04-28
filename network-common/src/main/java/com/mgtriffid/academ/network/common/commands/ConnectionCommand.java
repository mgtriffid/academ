package com.mgtriffid.academ.network.common.commands;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class ConnectionCommand {
    public Type type;

    public ConnectionCommand(Type type) {
        this.type = type;
    }

    public enum Type {
        CONNECTION_ALLOWED,
        CONNECTION_NOT_ALLOWED,
        CONNECTION_REQUESTED
    }
}
