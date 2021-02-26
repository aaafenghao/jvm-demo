package com.fh.statistics;

import java.util.Map;

public interface StatViewer {

    void output(Map<String,RequestStat> requestStats,long startTimeInMillis,long endTimeInMillis);
}
