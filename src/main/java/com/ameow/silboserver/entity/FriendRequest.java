package com.ameow.silboserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * description:
 *
 * @author Leslie Leung
 * @date 2021/6/26
 */
@Data
public class FriendRequest {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String from;
    private String to;
    private Date time;
    private Integer isPassed;

    public FriendRequest(String from, String to) {
        this.from = from;
        this.to = to;
        this.time = new Date();
        this.isPassed = 0;
    }
}
