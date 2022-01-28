package org.itstack.demo.service;

/**
 * @author ssqswyf
 * @date 2022/1/28
 */
public class UserService implements IUserService{
    @Override
    public String queryUserNameById(String userId) {
        return "Hi user " + userId;
    }
}
