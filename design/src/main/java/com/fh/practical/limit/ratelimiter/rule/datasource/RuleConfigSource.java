package com.fh.practical.limit.ratelimiter.rule.datasource;

import com.fh.practical.limit.ratelimiter.rule.RuleConfig;

public interface RuleConfigSource {

    RuleConfig load();
}
