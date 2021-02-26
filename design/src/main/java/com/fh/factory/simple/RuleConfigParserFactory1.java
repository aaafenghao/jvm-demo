package com.fh.factory.simple;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParserFactory1 {

    private static final Map<String,IRuleConfigParser> cacheParse = new HashMap<>();

    static {
        cacheParse.put("json",new JsonRuleConfigParse());
        cacheParse.put("xml",new XmlRuleConfigParse());
        cacheParse.put("yaml",new YamlRuleConfigParse());
        cacheParse.put("properties",new PropertiesRuleConfigParse());
    }

    public static IRuleConfigParser createParse(String configFormat){
        if(configFormat == null || configFormat.isEmpty()){
            return null;
        }
        IRuleConfigParser parser = cacheParse.get(configFormat);
        return parser;
    }
}
