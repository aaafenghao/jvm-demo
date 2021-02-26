package com.fh.interfaces;

import java.util.HashMap;

public class DefaultApiAuthenticator implements ApiAuthenticator {

    private CredentialStorage credentialStorage;

    public DefaultApiAuthenticator(){
        this.credentialStorage = new MysqlCredentialStorage();
    }

    public DefaultApiAuthenticator(CredentialStorage credentialStorage){
        this.credentialStorage = credentialStorage;
    }

    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.buildFromUrl(url);
        auth(apiRequest);
    }

    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String originalUrl = apiRequest.getOriginalUrl();

        AutoToken clientToken = new AutoToken(token,timestamp);
        if(clientToken.isExpired()){
            throw new RuntimeException("expired");
        }
        String passwordByAppId = credentialStorage.getPasswordByAppId(appId);
        AutoToken autoToken = AutoToken.create(null, 11, new HashMap<String, String>());
        if(autoToken.match(clientToken)){
            throw new RuntimeException("failed");
        }
    }
}
