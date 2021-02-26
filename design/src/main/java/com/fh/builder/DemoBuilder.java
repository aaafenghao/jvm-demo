package com.fh.builder;

import java.util.LinkedList;
import java.util.List;

public class DemoBuilder {

    public static void main(String[] args) {
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setMaxIdle(0)
                .setMaxTotal(0)
                .setMinIdle(0)
                .build();
        List<String> list = new LinkedList<>();
        list.remove(2);


    }
}
