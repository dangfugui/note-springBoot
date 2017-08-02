package com.dang.note.utils;

import java.util.ArrayList;
import java.util.List;

import org.thymeleaf.util.MapUtils;

public class ListUtils {
    public static  <T> List<T> arrayToList(T[] array){
        List<T> list = new ArrayList<>();
        if(array != null){
            for(T t: array){
                list.add(t);
            }
        }
        return list;
    }
}
