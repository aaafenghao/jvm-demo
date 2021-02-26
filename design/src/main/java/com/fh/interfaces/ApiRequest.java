package com.fh.interfaces;

public class ApiRequest {

    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    private String originalUrl;

    public ApiRequest(String baseUrl,String token,String appId,long timestamp){

    }

    public String getBaseUrl(){
        return null;
    }

    public String getToken(){
        return null;
    }

    public String getAppId(){
        return null;
    }

    public long getTimestamp(){
        return 0;
    }

    public String getOriginalUrl(){
        return null;
    }

    public static ApiRequest buildFromUrl(String url){
        return new ApiRequest(url,null,null,System.currentTimeMillis());
    }
}
