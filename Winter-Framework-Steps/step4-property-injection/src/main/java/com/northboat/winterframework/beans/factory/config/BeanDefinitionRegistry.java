package com.northboat.winterframework.beans.factory.config;

public interface BeanDefinitionRegistry {

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
