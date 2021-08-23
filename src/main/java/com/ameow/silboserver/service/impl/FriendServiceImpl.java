package com.ameow.silboserver.service.impl;

import com.ameow.silboserver.entity.Friend;
import com.ameow.silboserver.entity.FriendRequest;
import com.ameow.silboserver.entity.User;
import com.ameow.silboserver.mapper.FriendMapper;
import com.ameow.silboserver.mapper.FriendRequestMapper;
import com.ameow.silboserver.mapper.UserMapper;
import com.ameow.silboserver.service.FriendService;
import com.ameow.silboserver.vo.FriendListVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description:
 *
 * @author Leslie Leung
 * @date 2021/6/26
 */
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    private FriendRequestMapper friendRequestMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUser(String userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);

        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public Integer sendRequest(String from, String to) {
        return friendRequestMapper.insert(new FriendRequest(from, to));
    }

    @Override
    @Transactional
    public Integer acceptRequest(Integer reqId) {
        QueryWrapper<FriendRequest> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", reqId);
        FriendRequest friendRequest = friendRequestMapper.selectOne(queryWrapper);

        friendRequest.setIsPassed(1);
        String fromId = friendRequest.getFrom();
        String toId = friendRequest.getTo();

        friendMapper.insert(new Friend(fromId, toId));
        friendMapper.insert(new Friend(toId, fromId));
        return 1;
    }

    @Override
    public List<FriendListVO> getFriendList(String userId) {

        return friendMapper.getFriendList(userId);
    }
}
