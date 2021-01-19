package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @date 2020/05/28
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        //配置 xml 配置文件
        //启动 Spring 上下文环境
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definition-context.xml");
        User user = beanFactory.getBean("user",User.class);
        User aliasUser = beanFactory.getBean("xiangxuan-user",User.class);
        System.out.println(user == aliasUser);
    }
}
