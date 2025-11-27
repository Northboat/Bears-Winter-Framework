package com.northboat.winterframework.test.bean;


public class UserService {

    private String uId;

    private UserDao userDao;

    public UserService(String uId) {
        this.uId = uId;
    }

    public void setName(String name) {
        this.uId = name;
    }

    public String queryUserInfo(){
        System.out.println("Querying user info of " + uId + ": " + userDao.queryUserName(uId) );
        return userDao.queryUserName(uId);
    }
}