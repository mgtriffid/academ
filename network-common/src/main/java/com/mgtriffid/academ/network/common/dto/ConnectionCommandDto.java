package com.mgtriffid.academ.network.common.dto;

import com.mgtriffid.academ.network.common.commands.ConnectionCommand;
import org.apache.commons.lang3.NotImplementedException;

/**
 * Created by mgtriffid on 31.03.17.
 */
public class ConnectionCommandDto {

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    private Type type;

    public enum Type {
        CONNECTION_ALLOWED {
            @Override
            public ConnectionCommand.Type toRealType() {
                return ConnectionCommand.Type.CONNECTION_ALLOWED;
            }
        },
        CONNECTION_PERMITTED {
            @Override
            public ConnectionCommand.Type toRealType() {
                return ConnectionCommand.Type.CONNECTION_PERMITTED;
            }
        },
        CONNECTION_REQUESTED {
            @Override
            public ConnectionCommand.Type toRealType() {
                return ConnectionCommand.Type.CONNECTION_REQUESTED;
            }
        };

        public abstract ConnectionCommand.Type toRealType();

        static Type fromRealType(ConnectionCommand.Type type) {
            switch (type) {
                case CONNECTION_ALLOWED:
                    return CONNECTION_ALLOWED;
                case CONNECTION_PERMITTED:
                    return CONNECTION_PERMITTED;
                case CONNECTION_REQUESTED:
                    return CONNECTION_REQUESTED;
            }
            throw new NotImplementedException("Unknown enum type");
        }
    }
}
