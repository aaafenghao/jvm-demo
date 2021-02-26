package com.fh.statistics;

import java.util.List;
import java.util.Map;

public class ScheduledReport {


    private MetricsStorage storage;
    private Aggregator aggregator;
    private StatViewer viewer;

    public ScheduledReport(MetricsStorage storage,Aggregator aggregator,StatViewer viewer){
        this.storage = storage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    protected void doStatAndReport(long startInMillis,long endTimeInMillis){
        long durationInMillis = endTimeInMillis - startInMillis;
        Map<String, List<RequestInfo>> requestInfos = storage.getRequestInfos(startInMillis, endTimeInMillis);
        Map<String, RequestStat> aggregate = aggregator.aggregate(requestInfos, durationInMillis);
        viewer.output(aggregate,startInMillis,endTimeInMillis);
    }
}
