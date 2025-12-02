package com.northboat.winterframework.test;

import cn.hutool.core.io.IoUtil;
import com.northboat.winterframework.beans.factory.config.BeanDefinition;
import com.northboat.winterframework.beans.factory.config.BeanReference;
import com.northboat.winterframework.beans.factory.support.DefaultListableBeanFactory;
import com.northboat.winterframework.beans.PropertyValue;
import com.northboat.winterframework.beans.PropertyValues;
import com.northboat.winterframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.northboat.winterframework.context.support.ClassPathXmlApplicationContext;
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
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:winter.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

}
