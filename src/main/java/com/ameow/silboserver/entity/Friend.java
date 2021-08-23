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
public class Friend {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String friend1;
    private String friend2;
    private Date time;

    public Friend(String fromId, String toId) {
        this.friend1 = fromId;
        this.friend2 = toId;
        this.time = new Date();
    }
}
