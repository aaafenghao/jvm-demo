package com.fh.chainOfResp;

/**
 * 职责链的链式存储
 */
public class HandlerChain {

    private Handler head;

    private Handler tail;

    public void addHandle(Handler handler){
        handler.setSuccesser(null);

        if(head == null){
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccesser(handler);
        tail = handler;
    }

    public void handle(){
        if(head != null){
            head.handle();
        }
    }
}
