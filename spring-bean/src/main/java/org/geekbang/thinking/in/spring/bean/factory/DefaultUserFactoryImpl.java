package org.geekbang.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author xiangxuan
 * @date 2020/5/31
 */
public class DefaultUserFactoryImpl implements UserFactory, InitializingBean {

    public void initUserFactory(){
        System.out.println("自定义初始化 ： UserFactory 初始化中......");
    }
    @PostConstruct
    public void init(){
        System.out.println("PostConstruct ： UserFactory 初始化中...");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean ： afterPropertiesSet 实现...");
    }
}
