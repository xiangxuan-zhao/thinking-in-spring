package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.bean.factory.DefaultUserFactoryImpl;
import org.geekbang.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/01/20
 */
public class SingletonBeanRegisterDemo {
    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        UserFactory userFactory = new DefaultUserFactoryImpl();
        beanFactory.registerSingleton("user-single",userFactory);
        applicationContext.refresh();
        UserFactory beanLookUp = applicationContext.getBean("user-single", UserFactory.class);
        System.out.println(beanLookUp == userFactory);

        applicationContext.close();
    }
}
