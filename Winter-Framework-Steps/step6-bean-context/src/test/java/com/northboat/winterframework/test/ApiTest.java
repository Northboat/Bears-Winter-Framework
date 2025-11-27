package com.northboat.winterframework.test;

import cn.hutool.core.io.IoUtil;
import com.northboat.winterframework.beans.factory.config.BeanDefinition;
import com.northboat.winterframework.beans.factory.config.BeanReference;
import com.northboat.winterframework.beans.factory.support.DefaultListableBeanFactory;
import com.northboat.winterframework.beans.PropertyValue;
import com.northboat.winterframework.beans.PropertyValues;
import com.northboat.winterframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.northboat.winterframework.core.io.DefaultResourceLoader;
import com.northboat.winterframework.core.io.Resource;
import com.northboat.winterframework.test.bean.UserDao;
import com.northboat.winterframework.test.bean.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {

    @Test
    public void testBeanFactory(){

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册 UserDao
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 设置内置属性 uId 和 userDao
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 注册 UserService 并将内置属性注入
        BeanDefinition userServiceBean = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", userServiceBean);

        // 获取 UserService Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

    private DefaultResourceLoader resourceLoader;
    @BeforeEach
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_url() throws Exception {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_classpath() throws Exception {
        Resource resource = resourceLoader.getResource("classpath:test.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws Exception {
        Resource resource = resourceLoader.getResource("src/test/resources/test.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }


    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory, resourceLoader);
        reader.loadBeanDefinitions("classpath:winter.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

}
