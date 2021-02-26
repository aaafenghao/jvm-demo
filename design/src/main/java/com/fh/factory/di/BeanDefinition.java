package com.fh.factory.di;

import com.fh.statistics.ScheduledReport;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {

    private String id;
    private String className;
    private List<ConstructorArg> constructorArgList = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ConstructorArg> getConstructorArgList() {
        return constructorArgList;
    }

    public void setConstructorArgList(List<ConstructorArg> constructorArgList) {
        this.constructorArgList = constructorArgList;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public boolean isSingle(){
        return this.scope == Scope.SINGLETON;
    }

    public static enum Scope{
        SINGLETON,
        PROTOTYPE
    }

    public static class ConstructorArg{
        private boolean isRef;
        private Class type;
        private Object arg;

        public boolean isRef() {
            return isRef;
        }

        public void setRef(boolean ref) {
            isRef = ref;
        }

        public Class getType() {
            return type;
        }

        public void setType(Class type) {
            this.type = type;
        }

        public Object getArg() {
            return arg;
        }

        public void setArg(Object arg) {
            this.arg = arg;
        }
    }
}
