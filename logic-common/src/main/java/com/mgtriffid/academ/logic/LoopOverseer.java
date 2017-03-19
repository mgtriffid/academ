package com.mgtriffid.academ.logic;

import com.mgtriffid.academ.config.AcademConfig;
import org.pmw.tinylog.Logger;

/**
 * Created by mgtriffid on 19.03.17.
 */
public class LoopOverseer {
    long currentTick;
    long nextTick;
    int tickLengthMillis = AcademConfig.getTickLengthMillis();

    public boolean needUpdate() {
        long now = now();
        if (nextTick < now) {
            Logger.info("Need update, nextTick = {}, now = {}", nextTick, now);
            return true;
        } else {
            return false;
        }
    }

    public void tick() {
        nextTick += tickLengthMillis;
        Logger.info("nextTick is {}", nextTick);
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

    public long toNextTickMillis() {
        return nextTick - now();
    }
}
