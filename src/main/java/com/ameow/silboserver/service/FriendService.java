package com.ameow.silboserver.service;

import com.ameow.silboserver.entity.User;
import com.ameow.silboserver.vo.FriendListVO;

import java.util.List;

/**
 * description:
 *
 * @author Leslie Leung
 * @date 2021/6/26
 */
public interface FriendService {

    User findUser(String userId);

    Integer sendRequest(String from, String to);

    Integer acceptRequest(Integer reqId);

    List<FriendListVO> getFriendList(String userId);

}
