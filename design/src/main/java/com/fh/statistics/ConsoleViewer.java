package com.fh.statistics;

import java.util.Map;

public class ConsoleViewer implements StatViewer{
    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis) {
        System.out.println("");
    }
}
