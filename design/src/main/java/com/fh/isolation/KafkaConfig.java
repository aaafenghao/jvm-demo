package com.fh.isolation;

public class KafkaConfig implements Updater {

    private ConfigSource configSource;

    public KafkaConfig(ConfigSource configSource){
        this.configSource = configSource;
    }

    public void update() {

    }
}
