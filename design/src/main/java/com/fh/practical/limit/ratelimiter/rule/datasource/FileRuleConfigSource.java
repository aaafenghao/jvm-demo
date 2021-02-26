package com.fh.practical.limit.ratelimiter.rule.datasource;

import com.fh.practical.limit.ratelimiter.rule.RuleConfig;
import com.fh.practical.limit.ratelimiter.rule.parser.JSONRuleConfigParse;
import com.fh.practical.limit.ratelimiter.rule.parser.RuleConfigParse;
import com.fh.practical.limit.ratelimiter.rule.parser.YamlRuleConfigParse;
import com.fh.practical.limit.ratelimiter.rule.parser.YmlRuleConfigParse;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FileRuleConfigSource implements RuleConfigSource{

    public static final String API_LIMIT_CONFIG_NAME = "-rule";
    public static final String YAML_EXTENSION = "yaml";
    public static final String YML_EXTENSION = "yml";
    public static final String JSON_EXTENSION = "json";
    public static final String[] SUPPORT = new String[]{
            YAML_EXTENSION,YML_EXTENSION,JSON_EXTENSION
    };
    private static final Map<String, RuleConfigParse> PARSER_MAP = new HashMap<>();

    static {
        PARSER_MAP.put(YAML_EXTENSION,new YamlRuleConfigParse());
        PARSER_MAP.put(YML_EXTENSION,new YmlRuleConfigParse());
        PARSER_MAP.put(JSON_EXTENSION,new JSONRuleConfigParse());
    }

    @Override
    public RuleConfig load() {
        for (String extension : SUPPORT) {
            InputStream is = null;
            try {
                is = this.getClass().getResourceAsStream("");
                if(is != null){
                    RuleConfigParse ruleConfigParse = PARSER_MAP.get(extension);
                    RuleConfig parse = ruleConfigParse.parse(is);
                    return parse;
                }
            }finally {
                if(is != null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    private String getFileNameByExt(String extension) { return API_LIMIT_CONFIG_NAME + "." + extension; }
}
