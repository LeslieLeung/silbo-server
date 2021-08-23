package com.ameow.silboserver.mapper;

import com.ameow.silboserver.entity.Friend;
import com.ameow.silboserver.vo.FriendListVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * description:
 *
 * @author Leslie Leung
 * @date 2021/6/26
 */
public interface FriendMapper extends BaseMapper<Friend> {

    @Select("SELECT f.id, f.friend1, f.friend2, u.id, u.name FROM friend f, user u WHERE f.friend2 = u.id AND f.friend1 = #{userId}")
    List<FriendListVO> getFriendList(@Param("userId") String userId);
}
