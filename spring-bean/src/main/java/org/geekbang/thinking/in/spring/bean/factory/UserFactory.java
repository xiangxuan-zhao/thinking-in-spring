package org.geekbang.thinking.in.spring.bean.factory;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;

/**
 * @author xiangxuan
 * @date 2020/5/31
 */
public interface UserFactory {
    default User createUser(){
        return User.createUser();
    }
}
