package com.northboat.winterframework.beans.factory.config;

import com.northboat.winterframework.beans.factory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory {

    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";
}
