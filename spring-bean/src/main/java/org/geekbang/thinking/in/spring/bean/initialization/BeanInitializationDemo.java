package org.geekbang.thinking.in.spring.bean.initialization;

import org.geekbang.thinking.in.spring.bean.factory.DefaultUserFactoryImpl;
import org.geekbang.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 *  // TODO: 2021/1/19   spring bean GC
 * {@link Bean} 的初始化
 * @author Administrator
 * @date 2020/06/02
 */
//@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration class(配置类)
        applicationContext.register(BeanInitializationDemo.class);
        //启动spring应用上下文
        applicationContext.refresh();
        //spring 应用上下文启动
        System.out.println("spring 应用上下文启动......");
        //获取实例
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        //关闭spring 应用上下文
        System.out.println(userFactory);
        System.out.println("spring 应用上下文准备关闭...");
        applicationContext.close();
        System.out.println("spring 应用上下文已关闭...");
    }
    @Bean(initMethod = "initUserFactory",destroyMethod = "genricDestroy")
    public UserFactory user(){
        return new DefaultUserFactoryImpl();
    }
}
