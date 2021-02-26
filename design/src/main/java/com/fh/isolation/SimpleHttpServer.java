package com.fh.isolation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleHttpServer {

    private String host;

    private int port;

    private Map<String, List<Viewer>> viewers = new HashMap<String, List<Viewer>>();

    public SimpleHttpServer(String host,int port){

    }

    public void addViews(String urlDirectory,Viewer viewer){
        if(!viewers.containsKey(urlDirectory)){
            viewers.put(urlDirectory,new ArrayList<Viewer>());
        }
        this.viewers.get(urlDirectory).add(viewer);
    }

    public void run(){

    }
}
