package com.fh.factory.method;

import com.fh.factory.simple.IRuleConfigParser;
import com.fh.factory.simple.PropertiesRuleConfigParse;

public class PropertiesRuleConfigParseFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParse() {
        return new PropertiesRuleConfigParse();
    }
}
