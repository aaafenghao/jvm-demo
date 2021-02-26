package com.fh.isolation;

import java.util.Map;

public class RedisConfig implements Updater,Viewer {

    private ConfigSource configSource;
    private String address;
    private int timeout;
    private int maxTotal;


    public RedisConfig(ConfigSource configSource){
        this.configSource = configSource;
    }

    public String getAddress(){
        return this.address;
    }

    public void update(){
        //从configSource中获取信息
    }

    public String outputInPlainText() {
        return null;
    }

    public Map<String, String> output() {
        return null;
    }
}
