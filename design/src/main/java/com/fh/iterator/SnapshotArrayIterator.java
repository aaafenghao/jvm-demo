package com.fh.iterator;

import javax.naming.ldap.PagedResultsControl;
import java.util.ArrayList;

/**
 * 快照迭代器
 */
public class SnapshotArrayIterator<E> implements Iterator<E>{


    private long snapshotTimestamp;
    private int cursorAll;
    private int leftCount;
    private ArrayListF list;

    public SnapshotArrayIterator(ArrayListF arrayList){
        this.snapshotTimestamp = System.currentTimeMillis();
        this.cursorAll = 0;
        this.leftCount = arrayList.getTotalSize();
        this.list = arrayList;

    }


    @Override
    public boolean hasNext() {
        return this.leftCount >=0;
    }

    @Override
    public void next() {
        justNext();
    }

    @Override
    public E currentItem() {
        return (E) list.get(cursorAll);
    }

    private void justNext(){
        while (cursorAll < list.getTotalSize()){
            long addTimestamp = list.getAddTimestamp(cursorAll);
            long delTimestamp = list.getDelTimestamp(cursorAll);
            if(snapshotTimestamp > addTimestamp && snapshotTimestamp < delTimestamp){
                leftCount--;
                break;
            }
            cursorAll++;
        }
    }
}
