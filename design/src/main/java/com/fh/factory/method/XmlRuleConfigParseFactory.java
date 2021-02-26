package com.fh.factory.method;

import com.fh.factory.simple.IRuleConfigParser;
import com.fh.factory.simple.XmlRuleConfigParse;

public class XmlRuleConfigParseFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParse() {
        return new XmlRuleConfigParse();
    }
}
