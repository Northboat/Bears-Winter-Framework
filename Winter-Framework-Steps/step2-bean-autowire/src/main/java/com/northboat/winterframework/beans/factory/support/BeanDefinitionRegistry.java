package com.northboat.winterframework.beans.factory.support;

import com.northboat.winterframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
