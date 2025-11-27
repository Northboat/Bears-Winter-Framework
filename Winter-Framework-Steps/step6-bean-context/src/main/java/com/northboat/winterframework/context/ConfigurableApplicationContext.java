package com.northboat.winterframework.context;

import com.northboat.winterframework.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext{

    // 刷新容器
    void refresh() throws BeansException;
}
