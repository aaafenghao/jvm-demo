package com.fh.factory.method;

import com.fh.factory.simple.IRuleConfigParser;

public interface IRuleConfigParserFactory {

    IRuleConfigParser createParse();
}
