package com.fh.interfaces;

public interface ApiAuthenticator {

    void auth(String url);

    void auth(ApiRequest apiRequest);
}
