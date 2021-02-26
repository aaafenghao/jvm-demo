package com.fh.factory.di;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {

    private ConcurrentHashMap<String,Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();



    public void addBeanDefinitions(List<BeanDefinition> list){
        for (BeanDefinition definition:list){
            this.beanDefinitions.putIfAbsent(definition.getId(),definition);
        }
        for (BeanDefinition definition:list){
            if(definition.isLazyInit() == false && definition.isSingle()){
                create(definition);
            }
        }
    }

    protected Object create(BeanDefinition definition){
        if(definition.isSingle() && this.singletonObjects.containsKey(definition.getId())){
            return this.singletonObjects.get(definition.getId());
        }
        Object bean = null;
        try {
            Class<?> aClass = Class.forName(definition.getClassName());
            List<BeanDefinition.ConstructorArg> args = definition.getConstructorArgList();
            if(args.isEmpty()){
                bean = aClass.newInstance();
            }else{
                Class[] argClass = new Class[args.size()];
                Object[] argObject = new Object[args.size()];
                for (int i = 0; i < args.size(); ++i) {
                    BeanDefinition.ConstructorArg arg = args.get(i);
                    if(!arg.isRef()){
                        argClass[i] = arg.getType();
                        argObject[i] = arg.getArg();
                    }else {
                        BeanDefinition definition1 = this.beanDefinitions.get(arg.getArg());
                        if(definition1 == null){
                            throw new NoSuchFieldException("");
                        }
                        argClass[i] = Class.forName(definition1.getClassName());
                        argObject[i] = create(definition1);
                    }
                }
                bean = aClass.getConstructor(argClass).newInstance(argObject);
            }
        }catch (Exception e){

        }
        if(bean != null && definition.isSingle()){
            this.singletonObjects.putIfAbsent(definition.getId(),bean);
            return this.singletonObjects.get(definition.getId());
        }
        return bean;
    }

    public Object getBean(String name){
        return null;
    }
}
