package com.fh.practical.limit.ratelimiter.rule;

public class RateLimiterRule {

    private RuleConfig ruleConfig;

    public RateLimiterRule(RuleConfig ruleConfig){
        this.ruleConfig = ruleConfig;
    }

    public ApiLimit getLimit(String appId,String url){
        return new ApiLimit();
    }
}
