package com.fh.iterator;

public class ArrayListF<E> implements ListF<E>{

    private static final int DEFAULT_CAPACITY = 10;

    private int actualSize;
    private int totalSize;

    private Object[] elements;
    private long[] addTimestamps;
    private long[] delTimestamps;

    public ArrayListF(){
        this.elements = new Object[DEFAULT_CAPACITY];
        this.addTimestamps = new long[DEFAULT_CAPACITY];
        this.delTimestamps = new long[DEFAULT_CAPACITY];
        this.actualSize = 0;
        this.totalSize = 0;
    }

    @Override
    public void add(E e) {
        elements[totalSize] = e;
        addTimestamps[totalSize] = System.currentTimeMillis();
        delTimestamps[totalSize] = Long.MAX_VALUE;
        actualSize++;
        totalSize++;
    }

    @Override
    public void remove(E e) {
        for (int i = 0; i < elements.length; i++) {
            if(elements[i].equals(e)){
                delTimestamps[i] = System.currentTimeMillis();
                actualSize--;
            }
        }
    }

    public int getTotalSize(){
        return totalSize;
    }

    public int getActualSize(){
        return actualSize;
    }

    public E get(int i){
        if(i >= totalSize){
            throw new IndexOutOfBoundsException("");
        }
        return (E) elements[i];
    }

    public long getAddTimestamp(int i){
        if(i >= totalSize){
            throw new IndexOutOfBoundsException("");
        }
        return addTimestamps[i];
    }

    public long getDelTimestamp(int i){
        if(i >= totalSize){
            throw new IndexOutOfBoundsException("");
        }
        return delTimestamps[i];
    }
}
