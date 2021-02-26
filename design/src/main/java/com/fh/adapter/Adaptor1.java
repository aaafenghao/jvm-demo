package com.fh.adapter;

//对象适配--基于组合
public class Adaptor1 implements ITarget {

    private Adaptee adaptee;

    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {
        adaptee.fb();
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}
