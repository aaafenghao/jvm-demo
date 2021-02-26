package com.fh.statistics;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConsoleReporter {

    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer statViewer;
    private ScheduledExecutorService executorService;

    public ConsoleReporter(MetricsStorage metricsStorage,Aggregator aggregator,StatViewer statViewer){
        this.metricsStorage = metricsStorage;
        this.executorService = Executors.newSingleThreadScheduledExecutor();

        this.aggregator = aggregator;
        this.statViewer = statViewer;
    }

/*    public void startRepeatedReport(long periodInSeconds,long durationInSeconds){
        executorService.scheduleAtFixedRate((Runnable) () -> {
            long durationInMillils = durationInSeconds * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            long startTimeInMills = endTimeInMillis - durationInMillils;
            Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMills, endTimeInMillis);
            Map<String,RequestStat> stats = new HashMap<>();
            for(Map.Entry<String,List<RequestInfo>> entry:requestInfos.entrySet()){
                String apiName = entry.getKey();
                List<RequestInfo> value = entry.getValue();
                RequestStat aggregate = Aggregator.aggregate(value, durationInMillils);
                stats.put(apiName,aggregate);
            }

            System.out.println("");
        },0,periodInSeconds, TimeUnit.SECONDS);
    }*/

    public void startRepeatedReport(long periodInSeconds,long durationInSeconds){
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long durationInMillis = durationInSeconds * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                Map<String, RequestStat> aggregate = aggregator.aggregate(requestInfos, durationInMillis);
                statViewer.output(aggregate,startTimeInMillis,endTimeInMillis);

            }
        },0l,periodInSeconds,TimeUnit.SECONDS);
    }
}
