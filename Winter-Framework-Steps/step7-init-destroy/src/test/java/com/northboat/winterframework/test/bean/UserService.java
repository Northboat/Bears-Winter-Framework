package com.northboat.winterframework.test.bean;


import com.northboat.winterframework.beans.factory.DisposableBean;
import com.northboat.winterframework.beans.factory.InitializingBean;

public class UserService implements InitializingBean, DisposableBean {

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

    @Override
    public void destroy() throws Exception {
        System.out.println("UserService destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserService afterPropertiesSet");
    }
}