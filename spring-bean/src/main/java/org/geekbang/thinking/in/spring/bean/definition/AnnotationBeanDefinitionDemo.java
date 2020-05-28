package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Administrator
 * @date 2020/05/28
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)//通过import 导入
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration class(配置类)
        applicationContext.register(AnnotationBeanDefinitionDemo.class);
        //通过BeanDefinition注册 API 实现
        //1.命名bean方式
        registerUserBeanDefinition(applicationContext,"name-user");
        //2.非命名bean方式
        registerUserBeanDefinition(applicationContext);
        applicationContext.refresh();

        System.out.println( "User 类型" + applicationContext.getBeansOfType(User.class));
        System.out.println( "Config 类型" + applicationContext.getBeansOfType(Config.class));

        //显示关闭Spring应用上下文
        applicationContext.close();
    }

    /**
     * 命名Bean 注册方式
     * @param definitionRegistry
     * @param beanName
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry definitionRegistry, String beanName){
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        definitionBuilder.addPropertyValue("id",11)
                .addPropertyValue("name","罗密欧");
        if(StringUtils.hasText(beanName)){
            definitionRegistry.registerBeanDefinition(beanName,definitionBuilder.getBeanDefinition());
        }else{
            BeanDefinitionReaderUtils.registerWithGeneratedName(definitionBuilder.getBeanDefinition(),definitionRegistry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry definitionRegistry){
        registerUserBeanDefinition(definitionRegistry,null);
    }

    /**
     * 2.定义当前类为作为spring bean
     */
    @Component
    public static class Config{
        //通过注解方式定义一个Bean
        //1.通过 @Bean方式定义
        @Bean(name = {"user","userAlias"})
        public User user(){
            User user = new User();
            user.setId(100L);
            user.setName("I DO");
            return user;
        }
    }
}
