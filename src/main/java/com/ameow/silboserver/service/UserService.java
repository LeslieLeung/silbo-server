package com.ameow.silboserver.service;

/**
 * description:
 *
 * @author Leslie Leung
 * @date 2021/6/23
 */
public interface UserService {

    Integer register(String name, String password);

    Integer login(String name, String password);
}
