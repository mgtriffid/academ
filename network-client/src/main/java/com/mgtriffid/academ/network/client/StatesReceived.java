package com.mgtriffid.academ.network.client;

import com.mgtriffid.academ.logic.WorldState;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * Created by mgtriffid on 17.04.17.
 */
public class StatesReceived {
    private final List<Pair<Integer, WorldState>> states;

    public StatesReceived(List<Pair<Integer, WorldState>> states) {
        this.states = states;
    }

    public List<Pair<Integer, WorldState>> states() {
        return states;
    }
}
