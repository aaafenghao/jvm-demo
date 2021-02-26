package com.fh.isolation;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledUpdater {

    private final ScheduledExecutorService executors = Executors.newSingleThreadScheduledExecutor();

    private long initialDelayInSeconds;

    private long periodInSeconds;

    private Updater updater;

    public ScheduledUpdater(Updater updater,long initialDelayInSeconds,int periodInSeconds){
        this.updater = updater;
        this.initialDelayInSeconds = initialDelayInSeconds;
        this.periodInSeconds = periodInSeconds;
    }

    public void run(){
        executors.scheduleAtFixedRate(new Runnable() {
            public void run() {
                updater.update();
            }
        }, this.initialDelayInSeconds, this.periodInSeconds, TimeUnit.SECONDS);
    }
}
