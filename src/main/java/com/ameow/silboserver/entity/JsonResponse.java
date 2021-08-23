package com.ameow.silboserver.entity;

import lombok.Data;

/**
 * description:
 *
 * @author Leslie Leung
 * @date 2021/6/23
 */
@Data
public class JsonResponse<T> {
    private int code;
    private String msg;
    private T data;

    public JsonResponse() {
        this.code = 0;
        this.msg = "操作成功";
    }

    public JsonResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResponse(T data) {
        this.code = 0;
        this.msg = "操作成功";
        this.data = data;
    }

    public JsonResponse(T data, String msg) {
        this.code = 0;
        this.data = data;
        this.msg = msg;
    }
}
