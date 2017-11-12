package com.test.first.service.serviceimpl;

import com.test.first.domain.User;
import com.test.first.mapper.seconddata.UserMapper;
import com.test.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuning on 2017/9/21.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }
}
