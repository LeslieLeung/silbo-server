package com.ameow.silboserver.vo;

import lombok.Data;

/**
 * description:
 *
 * @author Leslie Leung
 * @date 2021/6/26
 */
@Data
public class FriendListVO {
    private Integer id;
    private String friend1;
    private String friend2;
    private Integer userId;
    private String name;
}
