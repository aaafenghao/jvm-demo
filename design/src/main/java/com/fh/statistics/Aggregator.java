package com.fh.statistics;

import java.util.*;

public class Aggregator {

/*    public static RequestStat aggregate(List<RequestInfo> requestInfos,long durationInMillis){
        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p99RespTime = -1;
        double p999RespTime = -1;
        double sunRespTime = 0;
        long count = 0;
        for (RequestInfo requestInfo:requestInfos){
            ++count;
            double responseTime = requestInfo.getResponseTime();
            if(maxRespTime < responseTime){
                maxRespTime = responseTime;
            }
            if(minRespTime > responseTime){
                minRespTime = responseTime;
            }
            sunRespTime += responseTime;

        }
        if(count != 0){
            avgRespTime = sunRespTime / count;
        }
        long tps = (long) (count / durationInMillis * 1000);
        Collections.sort(requestInfos, new Comparator<RequestInfo>() {
            @Override
            public int compare(RequestInfo o1, RequestInfo o2) {
                double diff = o1.getResponseTime() - o2.getResponseTime();
                if(diff < 0.0){
                    return -1;
                }else if(diff > 0.0){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        int idx999 = (int)(count * 0.999);
        int idx99 = (int)(count * 0.99);
        if(count != 0){
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }
        RequestStat requestStat = new RequestStat();
        return requestStat;

    }*/

    public Map<String,RequestStat> aggregate(
            Map<String,List<RequestInfo>> requestInfos,long durationInMillis
    ){
        Map<String,RequestStat> requestStats = new HashMap<>();
        for(Map.Entry<String,List<RequestInfo>> entry:requestInfos.entrySet()){
            String apiName = entry.getKey();
            List<RequestInfo> value = entry.getValue();
            RequestStat requestStat = doAggregate(value, durationInMillis);
            requestStats.put(apiName,requestStat);
        }
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos,long durationInMillis){
        List<Double> respTime = new ArrayList<>();
        for (RequestInfo requestInfo:requestInfos){
            double responseTime = requestInfo.getResponseTime();
            respTime.add(responseTime);
        }
        RequestStat stat = new RequestStat();
        stat.setMaxResponseTime(max(respTime));
        stat.setMinResponseTime(min(respTime));
        stat.setAvgResponseTime(avg(respTime));
        stat.setP99ResponseTime(percentile99(respTime));
        return stat;
    }

    private double max(List<Double> dataSet){
        return 0;
    }

    private double min(List<Double> dataSet){
        return 0;
    }

    private double avg(List<Double> dataSet){
        return 0;
    }

    private double tps(int count,double duration){
        return 0;
    }

    private double percentile999(List<Double> dataSet){
        return 0;
    }

    private double percentile99(List<Double> dataSet){
        return 0;
    }

    private double percentile(List<Double> dataSet,double ratio){
        return 0;
    }
}

