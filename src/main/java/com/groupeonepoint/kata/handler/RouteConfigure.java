package com.groupeonepoint.kata.handler;

import java.util.HashMap;
import java.util.Optional;
/*
    @author Elmehdi ZANGUI
 */
public class RouteConfigure<T> {
    private HashMap<T, T> map;
    private T fromHolder = null;
    private RouteConfigure() {
        this.map = new HashMap<>();
    }
    public static RouteConfigure build(){
        return new RouteConfigure();
    }
    public RouteConfigure from(T from){
        this.fromHolder = from;
        return this;
    }
    public RouteConfigure to(T to){
        if (fromHolder == null) {
            throw new IllegalStateException("A <<from>> point need to be set before defining <<to>> point");
        }
        if (map.containsKey(fromHolder)) {
            throw new IllegalStateException("A <<from>> point "+fromHolder+" is already defined with value " + map.get(fromHolder));
        }
        this.map.put(fromHolder, to);
        fromHolder = null;
        return this;
    }

    boolean containsRouteFrom(T from) {
        return map.containsKey(from);
    }
    Optional<T> getDestinationFrom(T from){
        return Optional.ofNullable(map.get(from));
    }


}
