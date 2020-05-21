package org.geekbang.thinking.in.spring.ioc.overview.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.overview.annotation.Super;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 根据名字查找
 * @author Administrator
 * @date 2020/05/19
 */
public class DependencyLookupDemo {
    public static void main(String[] args) throws Exception {
        //配置 xml 配置文件
        //启动 Spring 上下文环境
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INFO/dependency-lookup-context.xml");
        //lookupByType(beanFactory);
        lookupCollectionByType(beanFactory);
        lookupByAnnotation(beanFactory);
       //lookupInRealTime(beanFactory);
        //lookupInLazyTime(beanFactory);
    }
    private static void lookupByAnnotation(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> map = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找到的含有@Super注解的superUser 对象 " + map);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有 User 对象 " + map);
        }
    }
    private static void lookupByType(BeanFactory beanFactory){
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找" + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory){
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找" + user);
    }

    private static void lookupInLazyTime(BeanFactory beanFactory) throws Exception {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>)beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找" + user);
    }
}
