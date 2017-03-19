package com.mgtriffid.academ.network.common;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class ConnectionCommand {
    public Type type;

    public enum Type {
        CONNECTION_ALLOWED,
        CONNECTION_PERMITTED,
        CONNECTION_REQUESTED
    }
}
