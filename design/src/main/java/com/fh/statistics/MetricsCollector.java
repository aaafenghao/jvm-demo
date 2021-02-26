package com.fh.statistics;

import com.sun.deploy.util.StringUtils;

public class MetricsCollector {
    //基于接口而非实现
    private MetricsStorage metricsStorage;
    //依赖注入
    public MetricsCollector(MetricsStorage metricsStorage){
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo){
        if(requestInfo == null || requestInfo.getApiName() == null){
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
