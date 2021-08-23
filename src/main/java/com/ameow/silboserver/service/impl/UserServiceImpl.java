package com.ameow.silboserver.service.impl;

import com.ameow.silboserver.entity.User;
import com.ameow.silboserver.mapper.UserMapper;
import com.ameow.silboserver.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author Leslie Leung
 * @date 2021/6/23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer register(String name, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        User user = userMapper.selectOne(queryWrapper);

        if (user != null) {
            return -1;
        }
        return userMapper.insert(new User(name, password));
    }

    @Override
    public Integer login(String name, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        queryWrapper.eq("password", password);

        User user = userMapper.selectOne(queryWrapper);

        if (user != null) {
            return user.getId();
        } else {
            return 0;
        }
    }
}
