package com.fh.factory.method;

import com.fh.factory.simple.IRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParserFactoryMap {

    private static final Map<String,IRuleConfigParserFactory> cacheFactories = new HashMap<>();

    static {
        cacheFactories.put("json",new JsonRuleConfigParseFactory());
        cacheFactories.put("xml",new XmlRuleConfigParseFactory());
        cacheFactories.put("yaml",new YamlRuleConfigParseFactory());
        cacheFactories.put("properties",new PropertiesRuleConfigParseFactory());
    }

    public static IRuleConfigParserFactory getParseFactory(String type){
        if(type == null || type.isEmpty()){
            return null;
        }
        IRuleConfigParserFactory iRuleConfigParserFactory = cacheFactories.get(type);
        return iRuleConfigParserFactory;
    }
}
