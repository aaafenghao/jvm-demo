package com.fh.strategy.sort;

import java.util.HashMap;
import java.util.Map;

public class SortAlgFactory {

    private static final Map<String,ISortAlg> sortAlgs = new HashMap<>();

    static {
        sortAlgs.put("quickSort",new QuickSort());
        sortAlgs.put("externalSort",new ExternalSort());
        sortAlgs.put("ConcurrentExternalSort",new ConcurrentExternalSort());
        sortAlgs.put("MappreduceSort",new MapreduceSort());
    }

    public static ISortAlg getSortAlg(String type){
        if(type == null || type.isEmpty()){
            throw new IllegalArgumentException("");
        }
        return sortAlgs.get(type);
    }

}
