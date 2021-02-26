package com.fh.memo;

import java.util.Stack;

public class SnapshotHolder {

    private Stack<Snapshot> snapshots  = new Stack<>();

    public Snapshot popSnapshots(){
        return this.snapshots.pop();
    }

    public void pushSnapshots(Snapshot text){
        snapshots.push(text);
    }
}
