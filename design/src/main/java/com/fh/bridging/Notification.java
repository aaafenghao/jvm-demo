package com.fh.bridging;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.List;

public class Notification {

    private List<String> emailAddress;
    private List<String> telephones;
    private List<String> wechatIds;

    public void setEmailAddress(List<String> emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    public void setWechatIds(List<String> wechatIds) {
        this.wechatIds = wechatIds;
    }

    public void notify(NotificationEmergencyLevel level,String message){
        if(level.equals(NotificationEmergencyLevel.SEVERE)){

        }else if(level.equals(NotificationEmergencyLevel.URGENCY)){

        }else if(level.equals(NotificationEmergencyLevel.NORMAL)){

        }else if(level.equals(NotificationEmergencyLevel.TRIVIAL)){

        }
    }


}
