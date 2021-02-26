package com.fh.factory.di;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ClassPathApplicationContext implements ApplicationContext {

    private BeanFactory beanFactory;

    private BeanConfigParse beanConfigParse;

    public ClassPathApplicationContext(String configLocation){
        this.beanFactory = new BeanFactory();
        this.beanConfigParse = new XmlBeanConfigParse();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation){
        InputStream inputStream = null;
        try {
            inputStream = this.getClass().getResourceAsStream("/" + configLocation);
            if(inputStream == null){
                throw new RuntimeException("");
            }
            List<BeanDefinition> parse = beanConfigParse.parse(inputStream);
            beanFactory.addBeanDefinitions(parse);
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Override
    public Object getBean(String beanId) {
        return beanFactory.getBean(beanId);
    }
}
