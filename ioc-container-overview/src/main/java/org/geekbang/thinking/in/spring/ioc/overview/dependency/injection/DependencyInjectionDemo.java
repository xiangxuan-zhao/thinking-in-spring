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
        //BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INFO/dependency-injection-context.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INFO/dependency-injection-context.xml");
        //依赖来源一 : 自定义的bean
        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);

        System.out.println(userRepository.getObjectFactory().getObject() == applicationContext);
        //依赖来源二 :依赖注入（ 容器内建依赖）
        //System.out.println(userRepository.getBeanFactory());
        //依赖来源三 ： 容器内建bean(依赖查找）
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("{" + userRepository.getUserObjectFactory().getObject() + "}");
        System.out.println(userRepository.getApplicationContext() == applicationContext);
        System.out.println(environment);
    }

}
