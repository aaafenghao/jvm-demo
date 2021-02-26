package com.fh.practical.limit.ratelimiter;

import com.fh.practical.limit.ratelimiter.alg.RateLimitAlg;
import com.fh.practical.limit.ratelimiter.rule.ApiLimit;
import com.fh.practical.limit.ratelimiter.rule.RateLimiterRule;
import com.fh.practical.limit.ratelimiter.rule.RuleConfig;
import com.fh.practical.limit.ratelimiter.rule.datasource.FileRuleConfigSource;
import com.fh.practical.limit.ratelimiter.rule.datasource.RuleConfigSource;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {

    private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();

    private RateLimiterRule rule;

    private ThreadLocal<String> local = new ThreadLocal<>();

    public RateLimiter(){

        RuleConfigSource source = new FileRuleConfigSource();
        RuleConfig load = source.load();
        rule = new RateLimiterRule(load);
    }

    public boolean limit(String appId,String url){
        ApiLimit limit = rule.getLimit(appId, url);
        if(limit == null){
            return true;
        }
        String countKey = appId + ":"+limit.getApi();
        RateLimitAlg rateLimitAlg = counters.get(countKey);
        if(rateLimitAlg == null){
            RateLimitAlg rateLimitAlg1 = new RateLimitAlg(limit.getLimit());
            rateLimitAlg = counters.putIfAbsent(countKey,rateLimitAlg1);
            if(rateLimitAlg == null){
                rateLimitAlg = rateLimitAlg1;
            }
        }
        local.set("");
        return rateLimitAlg.tryAcquire();
    }


}
