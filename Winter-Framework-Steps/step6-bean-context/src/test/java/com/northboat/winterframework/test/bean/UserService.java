package com.northboat.winterframework.test.bean;


public class UserService {

    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    public UserService(String uId) {
        this.uId = uId;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String queryUserInfo(){
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }
}