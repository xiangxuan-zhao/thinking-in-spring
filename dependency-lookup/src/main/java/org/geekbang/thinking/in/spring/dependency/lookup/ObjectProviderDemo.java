package org.geekbang.thinking.in.spring.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.Iterator;

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
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        Iterable<String> stringIterator =  beanProvider;
       for(String str : stringIterator){
           System.out.println(str);
       }

        lookupIfAvailable(applicationContext);
        //Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
        //Arrays.stream(applicationContext.getBeanDefinitionNames()).filter(name->name.equals("helloWorld")).forEach(System.out::println);
        //根据类型查找bean
        //lookupByObjectProvider(applicationContext);
        //关闭
        applicationContext.close();
    }

    private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
//        Iterable<String> stringIterable = objectProvider;
//        for (String string : stringIterable) {
//            System.out.println(string);
//        }
        // Stream -> Method reference
        objectProvider.stream().forEach(System.out::println);
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        User user = userObjectProvider.getIfAvailable(User::createUser);
        System.out.println("当前 User 对象：" + user);
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(beanProvider.getObject());
    }

    @Bean
    @Primary
    public String helloWorld(){
        return "Hello World!";
    }

    @Bean
    public String local(){
        return "message";
    }
}
