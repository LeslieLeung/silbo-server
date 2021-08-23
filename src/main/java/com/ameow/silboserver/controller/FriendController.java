package com.ameow.silboserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.ameow.silboserver.entity.JsonResponse;
import com.ameow.silboserver.entity.User;
import com.ameow.silboserver.service.FriendService;
import com.ameow.silboserver.vo.FriendListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description:
 *
 * @author Leslie Leung
 * @date 2021/6/26
 */
@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @RequestMapping("/getFriendList")
    public JsonResponse<Object> getFriendList(@RequestBody JSONObject jsonRequest) {
        JSONObject data = jsonRequest.getJSONObject("data");

        String userId = data.getString("user_id");

        List<FriendListVO> friendList = friendService.getFriendList(userId);

        return new JsonResponse<>(friendList);
    }

    @RequestMapping("/findUser")
    public JsonResponse<Object> findUser(@RequestBody JSONObject jsonRequest) {
        JSONObject data = jsonRequest.getJSONObject("data");

        String userId = data.getString("user_id");

        User user = friendService.findUser(userId);

        return new JsonResponse<>(user);
    }

    @RequestMapping("/sendRequest")
    public JsonResponse<Object> sendRequest(@RequestBody JSONObject jsonRequest) {
        JSONObject data = jsonRequest.getJSONObject("data");

        String fromId = data.getString("from_id");
        String toId = data.getString("to_id");

        Integer res = friendService.sendRequest(fromId, toId);
        if (res != 0) {
            return new JsonResponse<>();
        } else {
            return new JsonResponse<>(400, "操作失败");
        }
    }

    @RequestMapping("/acceptRequest")
    public JsonResponse<Object> acceptRequest(@RequestBody JSONObject jsonRequest) {
        JSONObject data = jsonRequest.getJSONObject("data");

        Integer reqId = Integer.parseInt(data.getString("req_id"));
        Integer res = friendService.acceptRequest(reqId);

        if (res != 0) {
            return new JsonResponse<>();
        } else {
            return new JsonResponse<>(400, "操作失败");
        }
    }


}
