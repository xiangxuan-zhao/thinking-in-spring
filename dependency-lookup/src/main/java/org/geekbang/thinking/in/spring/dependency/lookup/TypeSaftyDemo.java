package org.geekbang.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
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

        //BeanFactory#getBean
        dispalayBeanFactoryGetBean(applicationContext);
        //ObjectFactory# getObject
        dispalayObjectFactoryGetObject(applicationContext);
        //ObjectProvider # getIfAvailable
        dispalayObjectProviderGetBean(applicationContext);

        applicationContext.close();
    }

    private static void dispalayObjectProviderGetBean(ApplicationContext applicationContext) {

    }

    private static void dispalayObjectFactoryGetObject(ApplicationContext beanFactory) {

    }

    private static void dispalayBeanFactoryGetBean(BeanFactory beanFactory) {

    }

    static  void printBeansException(String msg,Runnable runnable){
        try{
            runnable.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
