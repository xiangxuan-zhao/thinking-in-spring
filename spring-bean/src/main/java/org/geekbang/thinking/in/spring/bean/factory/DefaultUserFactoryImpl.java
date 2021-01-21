package org.geekbang.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xiangxuan
 * @date 2020/5/31
 */
public class DefaultUserFactoryImpl implements UserFactory, InitializingBean, DisposableBean {

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

    @PreDestroy
    public void annotionDestroy(){
        System.out.println("annotionDestroy 销毁...");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy 销毁方法...");
    }

    public void genricDestroy(){
        System.out.println("自定义 销毁...");
    }

    @Override
    protected void finalize() {
        System.out.println(this.getClass().getName() + "正在被回收 ");
    }
}
