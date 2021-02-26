package com.fh.statistics;

import java.util.*;

public class EmailReporter extends ScheduledReport {

    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private EmailSender emailSender;

    private Aggregator aggregator;
    private StatViewer statViewer;

    private List<String> toAddress = new ArrayList<>();

    public EmailReporter(MetricsStorage metricsStorage,EmailSender emailSender,Aggregator aggregator,StatViewer statViewer){
        super(metricsStorage,aggregator,statViewer);
        this.emailSender = emailSender;
    }

    public EmailReporter(MetricsStorage metricsStorage){
        this(metricsStorage,new EmailSender(),new Aggregator(),new EmailViewer());
    }

    public void addToAddress(String address){
        toAddress.add(address);
    }

    public void startDailyReport(){
        Date firstTime = this.trimTimeFieldsToZeroOfNextDay(new Date());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
               doStatAndReport(startTimeInMillis,endTimeInMillis);
            }
        },firstTime,DAY_HOURS_IN_SECONDS * 1000);
    }

    private Date trimTimeFieldsToZeroOfNextDay(Date date
    ){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        Date firstTime = calendar.getTime();
        return firstTime;
    }
}

