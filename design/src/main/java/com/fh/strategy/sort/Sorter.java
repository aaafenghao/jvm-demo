package com.fh.strategy.sort;


import sun.misc.GC;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Sorter {

    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath){
        File file = new File(filePath);
        long length = file.length();
        ISortAlg iSortAlg;
        if(length < 6 * GB){
            iSortAlg = new QuickSort();
        }else if(length < 10 *GB){
            iSortAlg = new ExternalSort();
        }else if(length < 100 *GB){
            iSortAlg = new ConcurrentExternalSort();
        }else{
            iSortAlg = new MapreduceSort();
        }
        iSortAlg.sort(filePath);
    }

    public void sortFile1(String filePath){
        File file = new File(filePath);
        long length = file.length();
        ISortAlg iSortAlg;
        if(length < 6 * GB){
            iSortAlg = SortAlgFactory.getSortAlg("");
        }else if(length < 10 *GB){
            iSortAlg = SortAlgFactory.getSortAlg("");
        }else if(length < 100 *GB){
            iSortAlg = SortAlgFactory.getSortAlg("");
        }else{
            iSortAlg = SortAlgFactory.getSortAlg("");
        }
        iSortAlg.sort(filePath);
    }

    private final static List<AlgRange> ranges = new ArrayList<>();

    static {
        ranges.add(new AlgRange(0,6*GB,new QuickSort()));
        ranges.add(new AlgRange(6 *GB,10 * GB,new ExternalSort()));
        ranges.add(new AlgRange(10 * GB,100 * GB,new ConcurrentExternalSort()));
        ranges.add(new AlgRange(100 * GB,Long.MAX_VALUE,new MapreduceSort()));
    }

    public void sortFile2(String filePath){
        File file = new File(filePath);
        long length = file.length();
        ISortAlg sortAlg = null;
        for (AlgRange range : ranges) {
            if(range.isRange(length)){
                sortAlg = range.getSortAlg();
            }
        }
        sortAlg.sort(filePath);
    }

    private static class AlgRange{
        private long start;
        private long end;
        private ISortAlg sortAlg;

        public AlgRange(long start,long end,ISortAlg sortAlg){
            this.start = start;
            this.end = end;
            this.sortAlg = sortAlg;
        }

        public boolean isRange(long size){
            return size >= start && size <= end;
        }

        public ISortAlg getSortAlg(){
            return sortAlg;
        }

    }
}

