package org.geekbang.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author Administrator
 * @date 2020/06/03
 */
public class ObjectProviderDemo {
    public static void main(String[] args) {
        //创建BeanFactory
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册配置类
        applicationContext.register(ObjectProviderDemo.class);
        //启动spring上下文
        applicationContext.refresh();
        //根据类型查找bean
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(beanProvider.getObject());

        //关闭
        applicationContext.close();
    }
    @Bean
    public String helloWorld(){
        return "Hello World!";
    }
}
