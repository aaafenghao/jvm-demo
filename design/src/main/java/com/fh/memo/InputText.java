package com.fh.memo;

public class InputText {

    private StringBuilder text = new StringBuilder();

    public String getText(){
        return text.toString();
    }

    public void append(String input){
        this.text.append(input);
    }

/*    public void setText(String text){
        this.text.replace(0,this.text.length(),text);
    }*/

    public Snapshot createSnapshot(){
        return new Snapshot(text.toString());
    }

    public void restoreSnapshot(Snapshot snapshot){
        this.text.replace(0,this.text.length(),snapshot.getText());
    }


}
