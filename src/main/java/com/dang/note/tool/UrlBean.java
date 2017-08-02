package com.dang.note.tool;

import java.util.LinkedHashMap;
import java.util.Map;

public class UrlBean {
    private String base;
    private Map<String,String> getMap = new LinkedHashMap<>();
    public UrlBean(String base){
        this.base = base;
    }
    public void addGetProperty(String key,String value){
        getMap.put(key,value);
    }
    public String getUrl(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(base);
        if(getMap.size()>0){
            stringBuffer.append("?");
            for(Map.Entry entry:getMap.entrySet()){
                stringBuffer.append(entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(entry.getValue());
                stringBuffer.append("&");
            }
        }
        return stringBuffer.toString();
    }
}
