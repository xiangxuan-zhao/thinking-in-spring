package org.geekbang.thinking.in.spring.ioc.overview.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author Administrator
 * @date 2020/05/27
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        //配置 xml配置
        //启动 spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INFO/dependency-injection-context.xml");
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INFO/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository",UserRepository.class);
        //System.out.println(userRepository.getUsers());
        //通过类型 依赖注入 userRepository.getBeanFactory()                        |  依赖查找 beanFactory.getBean(BeanFactory.class)(错误）
        // org.springframework.beans.factory.support.DefaultListableBeanFactory   |  NoSuchBeanDefinition
        System.out.println(userRepository.getBeanFactory() == beanFactory);
        System.out.println(userRepository.getBeanFactory());

        //System.out.println(beanFactory.getBean(BeanFactory.class));
        System.out.println(userRepository.getUserObjectFactory().getObject());
        System.out.println(userRepository.getObjectFactory().getObject());
        System.out.println(beanFactory);
        System.out.println(userRepository.getApplicationContext());

        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INFO/dependency-injection-context.xml");
        //依赖来源一 : 自定义的bean
        //UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);

        //System.out.println(userRepository.getObjectFactory().getObject() == applicationContext);
        //依赖来源二 :依赖注入（容器内建依赖）
        //System.out.println(userRepository.getBeanFactory());
        //依赖来源三 ： 容器内建bean(依赖查找）
        Environment environment = beanFactory.getBean(Environment.class);
        //System.out.println("{" + userRepository.getUserObjectFactory().getObject() + "}");
        //System.out.println(userRepository.getApplicationContext() == applicationContext);
        //System.out.println(environment);
    }

}
