package com.fh.factory.method;

import com.fh.factory.simple.IRuleConfigParser;
import com.fh.factory.simple.JsonRuleConfigParse;

public class JsonRuleConfigParseFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParse() {
        return new JsonRuleConfigParse();
    }
}
