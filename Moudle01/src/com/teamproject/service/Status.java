package com.teamproject.service;

/**
 * @author zzl
 * @Description
 * @date 2021/10/3 - 8:54
 */
//public class Status {
//    private final String NAME;
//    private Status(String name) {
//        this.NAME = name;
//    }
//    public static final Status FREE = new Status("FREE");
//    public static final Status VOCATION = new Status("VOCATION");
//    public static final Status BUSY = new Status("BUSY");
//    public String getNAME() {
//        return NAME;
//    }
//    @Override
//    public String toString() {
//        return NAME;
//    }
//}
public enum Status {
    FREE,BUSY,VOCATION;
}