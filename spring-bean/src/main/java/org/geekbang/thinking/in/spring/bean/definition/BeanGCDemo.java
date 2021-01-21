package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.bean.initialization.BeanInitializationDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/01/20
 */
public class BeanGCDemo {
    public static void main(String[] args) throws InterruptedException {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration class(配置类)
        applicationContext.register(BeanInitializationDemo.class);
        //启动spring应用上下文
        applicationContext.refresh();

        applicationContext.close();
        Thread.sleep(2000L);
        System.gc();
        Thread.sleep(1000L);
    }
}
