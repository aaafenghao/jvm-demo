package com.fh.factory.method;

import com.fh.factory.simple.IRuleConfigParser;
import com.fh.factory.simple.InvalidRuleConfigException;
import com.fh.factory.simple.RuleConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath){
        String fileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParserFactory parseFactory = RuleConfigParserFactoryMap.getParseFactory(fileExtension);
        if(parseFactory == null){
            throw new InvalidRuleConfigException("");
        }
        IRuleConfigParser parse = parseFactory.createParse();
        RuleConfig parse1 = parse.parse("");
        return parse1;
    }

    public String getFileExtension(String filePath){
        return "json";
    }
}
