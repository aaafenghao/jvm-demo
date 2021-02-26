package com.fh.observers.asyc;

import com.fh.observers.Message;
import com.fh.observers.Subject;
import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ObserverRegistry {

    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    public void registry(Object observer){
        Map<Class<?>, Collection<ObserverAction>> allObserverActions = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : allObserverActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> value = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> observerActions = registry.get(eventType);
            if(observerActions == null){
                registry.putIfAbsent(eventType,new CopyOnWriteArraySet<>());
                observerActions = registry.get(eventType);
            }
            observerActions.addAll(value);
        }
    }

    public List<ObserverAction> getMatchedObserverAction(Object event){
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> aClass = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> classCopyOnWriteArraySetEntry : registry.entrySet()) {
            Class<?> eventType = classCopyOnWriteArraySetEntry.getKey();
            CopyOnWriteArraySet<ObserverAction> value = classCopyOnWriteArraySetEntry.getValue();
            if(aClass.isAssignableFrom(eventType)){
                matchedObservers.addAll(value);
            }
        }
        return matchedObservers;
    }

    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer){
        Map<Class<?>,Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> aClass = observer.getClass();
        for (Method annotatedMethod : getAnnotatedMethods(aClass)) {
            Class<?>[] parameterTypes = annotatedMethod.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            if(!observerActions.containsKey(eventType)){
                observerActions.put(eventType,new ArrayList<>());
            }
            observerActions.get(eventType).add(new ObserverAction(observer,annotatedMethod));
        }
        return observerActions;
    }


    private List<Method> getAnnotatedMethods(Class<?> clazz){
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method:clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(Subscribe.class)){
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1,
                        "Method %s has @Subscribe but has %s parameter,Subscribe methods must have exactly 1 parameter",
                    method,parameterTypes.length);
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}
