package com.fh.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 不含状态的话，可以使用这样的方式进行共享
 * 如果包含状态,那就需要new了
 */
public class StrategyFactory {

    private static final Map<String,Strategy> strategys = new HashMap<>();

    static {
        strategys.put("A",new ConcreteStrategyA());
        strategys.put("B",new ConcreteStrategyB());
    }

    public static Strategy getStrategy(String type){
        if(type == null || type.isEmpty()){
            throw new IllegalArgumentException("");
        }
        return strategys.get(type);
    }
}
