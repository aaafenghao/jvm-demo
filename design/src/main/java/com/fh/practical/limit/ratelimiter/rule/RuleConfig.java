package com.fh.practical.limit.ratelimiter.rule;

import java.util.List;

public class RuleConfig {

    private List<AppRuleConfig> configs;

    public List<AppRuleConfig> getConfigs(){
        return this.configs;
    }

    public void setConfigs(List<AppRuleConfig> configs){
        this.configs = configs;
    }


    public static class AppRuleConfig{
        private String appId;
        private List<ApiLimit> limits;

        public AppRuleConfig(){

        }
        public AppRuleConfig(String appId,List<ApiLimit> limits){
            this.appId = appId;
            this.limits = limits;
        }
    }
}
