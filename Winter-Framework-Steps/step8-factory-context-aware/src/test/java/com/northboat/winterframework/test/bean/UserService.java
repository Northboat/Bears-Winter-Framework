package com.northboat.winterframework.test.bean;


import com.northboat.winterframework.beans.BeansException;
import com.northboat.winterframework.beans.factory.*;
import com.northboat.winterframework.context.ApplicationContext;

public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    // 上下文和工厂感知
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

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
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.applicationContext = context;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) throws BeansException {
        System.out.println("setBeanClassLoader: " + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName: " + name);
    }
}