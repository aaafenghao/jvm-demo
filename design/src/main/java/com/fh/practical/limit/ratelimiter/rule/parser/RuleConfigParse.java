package com.fh.practical.limit.ratelimiter.rule.parser;

import com.fh.practical.limit.ratelimiter.rule.RuleConfig;

import java.io.InputStream;

public interface RuleConfigParse {

    RuleConfig parse(String configText);

    RuleConfig parse(InputStream inputStream);
}
