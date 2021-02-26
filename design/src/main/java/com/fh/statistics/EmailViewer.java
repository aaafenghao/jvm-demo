package com.fh.statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmailViewer implements StatViewer{

    private EmailSender emailSender;

    private List<String> toAddresses = new ArrayList<>();


    public EmailViewer(){
        emailSender = new EmailSender();
    }

    public EmailViewer(EmailSender emailSender){
        this.emailSender = emailSender;
    }

    public void addToAddress(String address){
        toAddresses.add(address);
    }

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis) {

    }
}
