package com.northboat.winterframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod(){
        System.out.println("Running initDataMethod");
        hashMap.put("10001", "northboat");
        hashMap.put("10002", "summer");
        hashMap.put("10003", "framework");
    }

    public void destroyDataMethod(){
        System.out.println("Running destroyDataMethod");
        hashMap.clear();
    }

    public String queryUserName(String uid){
        return hashMap.get(uid);
    }
}
