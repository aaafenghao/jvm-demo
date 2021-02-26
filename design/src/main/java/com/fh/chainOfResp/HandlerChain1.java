package com.fh.chainOfResp;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain1 {

    private List<IHandler> list = new ArrayList<>();

    public void addHandle(IHandler handler){
        this.list.add(handler);
    }

    public void handle(){
        for (IHandler iHandler : list) {
            boolean handle = iHandler.handle();
            if(handle){
                break;
            }
        }
    }
}
