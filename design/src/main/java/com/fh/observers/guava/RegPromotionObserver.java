package com.fh.observers.guava;

import com.google.common.eventbus.Subscribe;

public class RegPromotionObserver {

    private PromotionService promotionService;

    @Subscribe
    public void handleRegSuccess(long id){

    }
}
