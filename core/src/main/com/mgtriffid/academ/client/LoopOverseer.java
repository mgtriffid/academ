package com.mgtriffid.academ.client;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class LoopOverseer {
    long currentTick;
    long nextTick;
    int tickLengthMillis = 20;

    public boolean needUpdate() {
        if (nextTick < now()) {
            nextTick += tickLengthMillis;
            return true;
        } else {
            return false;
        }
    }

    public void start() {
        nextTick = now() + tickLengthMillis;
    }

    private long now() {
        return System.currentTimeMillis();
    }

    public float alpha() {
        return 1 - (nextTick - now()) / tickLengthMillis;
    }
}
