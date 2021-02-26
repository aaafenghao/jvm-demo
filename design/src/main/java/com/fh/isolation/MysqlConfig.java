package com.fh.isolation;

import java.util.Map;

public class MysqlConfig implements Viewer {

    public ConfigSource configSource;

    public MysqlConfig(ConfigSource configSource){
        this.configSource = configSource;
    }

    public String outputInPlainText() {
        return null;
    }

    public Map<String, String> output() {
        return null;
    }
}
