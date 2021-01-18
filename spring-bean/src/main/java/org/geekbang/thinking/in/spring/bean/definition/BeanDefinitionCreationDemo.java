package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.stream.Stream;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * @author xiangxuan
 * @date 2020/5/28
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        //1.通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //属性设置
        beanDefinitionBuilder.addPropertyValue("id",1);
        beanDefinitionBuilder.addPropertyValue("name","xxz");
        //获取BeanDefinition实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //BeanDefinition 不是终态，可以修改
      /*  System.out.println(beanDefinition.getBeanClassName());
        MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
        PropertyValue[] propertyValues = mutablePropertyValues.getPropertyValues();
        for(PropertyValue propertyValue : propertyValues){
            System.out.println(propertyValue.getName() + " = " + propertyValue.getValue());
        }*/
        //2.通过AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
       // propertyValues.addPropertyValue("id",123);

        propertyValues.add("id",11)
        .add("name","xx");

        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
