package com.fh.factory.simple;

public class RuleConfigSource {

    //----------------------------------------------------------
    public RuleConfig load(String ruleConfigFilePath){
        String fileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = null;
        if("json".equalsIgnoreCase(fileExtension)){
            parser = new JsonRuleConfigParse();
        }else if("xml".equalsIgnoreCase(fileExtension)){
            parser = new XmlRuleConfigParse();
        }else if("yaml".equalsIgnoreCase(fileExtension)){
            parser = new YamlRuleConfigParse();
        }else if("properties".equalsIgnoreCase(fileExtension)){
            parser = new PropertiesRuleConfigParse();
        }else{
            throw new InvalidRuleConfigException("");
        }
        String configText = "";
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }
    //-----------------------------------------------------------

    public RuleConfig load1(String ruleConfigFilePath){
        String fileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = createParse(fileExtension);
        if(parser == null){
            throw new InvalidRuleConfigException("");
        }
        String configText = "";
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private IRuleConfigParser createParse(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParse();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParse();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParse();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParse();
        }
        return parser;
    }
    //----------------------------------------------------------------
    public RuleConfig load2(String ruleConfigFilePath){
        String fileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory.createParse(fileExtension);
        if(parser == null){
            throw new InvalidRuleConfigException("");
        }
        String configText = "";
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }


    public String getFileExtension(String filePath){
        return "json";
    }

}
