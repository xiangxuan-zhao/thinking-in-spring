package org.geekbang.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/01/28
 */
public class HierarchicalDependercyDemo {
    public static void main(String[] args) {
        //创建BeanFactory
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册配置类
        applicationContext.register(ObjectProviderDemo.class);

//        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
//        beanFactory.setParentBeanFactory(getBeanFactory());
//
//        HierarchicalBeanFactory  parentBeanFactory =(HierarchicalBeanFactory) beanFactory.getParentBeanFactory();
//        System.out.println(parentBeanFactory);
//        disPlayLocalBean(beanFactory,"user");

        //启动spring上下文
        applicationContext.refresh();
    }

    private static HierarchicalBeanFactory getBeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:/META-INFO/dependency-lookup-context.xml");
        return beanFactory;
    }

    private static void disPlayLocalBean(HierarchicalBeanFactory hbeanFactory,String beanName){
        System.out.println("当前beanFactory 是否包含 bean[]" + beanName + hbeanFactory.containsLocalBean(beanName));
    }

    private static void lookupLazy(){

    }
}
