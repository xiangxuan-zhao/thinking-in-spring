package org.geekbang.thinking.in.spring.bean.instance;

import org.geekbang.thinking.in.spring.bean.factory.DefaultUserFactoryImpl;
import org.geekbang.thinking.in.spring.bean.factory.UserFactory;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/01/19
 */
public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        //beanFactory 
       // BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-initialization-context.xml");

        //特殊方式 实例化spring bean  ，ServiceLoadFactoryBean
       // ServiceLoader<UserFactory> loadUserFactory = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        //ServiceLoader<UserFactory> userFactoryServiceLoad = beanFactory.getBean("userFactoryServiceLoad", ServiceLoader.class);
        //disPlay(userFactoryServiceLoad);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-initialization-context.xml");
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        UserFactory userFactory = autowireCapableBeanFactory.createBean(DefaultUserFactoryImpl.class);
        System.out.println(userFactory.createUser());
    }

    private static void disPlay(ServiceLoader<UserFactory> loadUserFactory){
        for (UserFactory userFactory : loadUserFactory) {
            System.out.println(userFactory.createUser());
        }
    }
}
