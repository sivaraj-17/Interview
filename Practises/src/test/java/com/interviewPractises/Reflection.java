package com.interviewPractises;

import java.lang.reflect.*;

public class Reflection {
    public static void main(String[] args) {
        Games games = new Games();
        Class<? extends Games> aClass = games.getClass();
        System.out.println(aClass.getName());
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
