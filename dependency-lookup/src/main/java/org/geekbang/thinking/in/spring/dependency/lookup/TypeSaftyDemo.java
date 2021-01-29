package org.geekbang.thinking.in.spring.dependency.lookup;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/01/28
 */
public class TypeSaftyDemo {
    public static void main(String[] args) {
        //创建BeanFactory
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册配置类
        applicationContext.register(TypeSaftyDemo.class);

        //启动spring上下文
        applicationContext.refresh();

        applicationContext.close();
    }
}
