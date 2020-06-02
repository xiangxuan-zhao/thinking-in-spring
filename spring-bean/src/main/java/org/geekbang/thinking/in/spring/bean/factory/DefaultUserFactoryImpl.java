package org.geekbang.thinking.in.spring.bean.factory;

import javax.annotation.PostConstruct;

/**
 * @author xiangxuan
 * @date 2020/5/31
 */
public class DefaultUserFactoryImpl implements UserFactory {
    @PostConstruct
    public void init(){
        System.out.println("PostConstruct UserFactory 初始化中...");
    }
}
