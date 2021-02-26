package com.fh.iterator;

public interface Iterator<E> {

    boolean hasNext();

    void next();

    E currentItem();
}
