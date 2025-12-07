package com.northboat.winterframework.context.event;

import com.northboat.winterframework.beans.BeansException;
import com.northboat.winterframework.beans.factory.BeanFactory;
import com.northboat.winterframework.beans.factory.BeanFactoryAware;
import com.northboat.winterframework.context.ApplicationEvent;
import com.northboat.winterframework.context.ApplicationListener;

public class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {

    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {

    }

    @Override
    public void multicastEvent(ApplicationEvent event) {

    }
}
