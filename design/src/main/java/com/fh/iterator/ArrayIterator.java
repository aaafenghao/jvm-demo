package com.fh.iterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayIterator<E> implements Iterator<E>{

    private int cursor;
    private ArrayList<E> arrayList;

    public ArrayIterator(ArrayList list){
        this.cursor = 0;
        this.arrayList = list;
    }

    @Override
    public boolean hasNext() {
        return cursor != arrayList.size();
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() {
        if(this.cursor >= arrayList.size()){
            throw new NoSuchElementException("");
        }
        return arrayList.get(cursor);
    }
}
