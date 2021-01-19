package org.geekbang.thinking.in.spring.bean.instance;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/01/19
 */
public class OtherTest {
    public static User createUserOther(){
        User user = new User();
        user.setName("other");
        user.setId(168L);
        return user;
    }
}
