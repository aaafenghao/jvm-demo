package com.fh.factory.method;

import com.fh.factory.simple.IRuleConfigParser;
import com.fh.factory.simple.YamlRuleConfigParse;

public class YamlRuleConfigParseFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParse() {
        return new YamlRuleConfigParse();
    }
}
