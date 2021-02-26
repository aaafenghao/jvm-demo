package com.fh.statistics;

public class RequestInfo {

    private String apiName;

    private double responseTime;

    private long timestamp;

    public String getApiName(){
        return this.apiName;
    }

    public double getResponseTime(){
        return this.responseTime;
    }
}
