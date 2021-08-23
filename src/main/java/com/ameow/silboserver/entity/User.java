package com.ameow.silboserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * description:
 *
 * @author Leslie Leung
 * @date 2021/6/23
 */
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private String gender;
    private String avatar;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
