package com.fh.memo;

import java.util.Scanner;

public class ApplicationMain {

    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.next();
            if(input.equals(":list")){
                System.out.println(inputText.getText());
            }else if(input.equals(":undo")){
                Snapshot snapshot = snapshotHolder.popSnapshots();
                inputText.restoreSnapshot(snapshot);
            }else {
                snapshotHolder.pushSnapshots(inputText.createSnapshot());
                inputText.append(input);
            }
        }
    }
}
