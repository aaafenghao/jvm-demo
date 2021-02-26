package com.fh.chainOfResp;

public abstract class Handler {

    protected Handler successer = null;

    public void setSuccesser(Handler handler){
        this.successer  = handler;
    }

    public final void handle(){
        boolean b = doHandle();
        if(successer != null && !b){
            successer.handle();
        }
    }

    protected abstract boolean doHandle();
}
