package com.ameow.silboserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.ameow.silboserver.entity.JsonResponse;
import com.ameow.silboserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * description:
 *
 * @author Leslie Leung
 * @date 2021/6/23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("register")
    public JsonResponse<Object> register(@RequestBody JSONObject jsonRequest) {
        JSONObject data = jsonRequest.getJSONObject("data");

        String name = data.getString("name");
        String password = data.getString("password");

        int res = userService.register(name, password);
        System.out.println("yes!");
        if (res == 1) {
            return new JsonResponse<>();
        } else if (res == -1) {
            return new JsonResponse<>(400, "已经注册");
        } else {
            return new JsonResponse<>(400, "操作失败");
        }
    }

    @RequestMapping("login")
    public JsonResponse<Object> login(@RequestBody JSONObject jsonRequest) {
        JSONObject data = jsonRequest.getJSONObject("data");

        String name = data.getString("name");
        String password = data.getString("password");

        Integer res = userService.login(name, password);

        HashMap<String, String> respData = new HashMap<>(1);
        respData.put("user_id", Integer.toString(res));
        if (res != 0) {
            return new JsonResponse<>(respData);
        } else {
            return new JsonResponse<>(400, "操作失败");
        }
    }
}
