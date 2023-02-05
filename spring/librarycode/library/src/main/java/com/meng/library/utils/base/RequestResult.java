package com.meng.library.utils.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestResult implements Serializable {

    private int code; // 200是正常，非200表示异常
    private String msg;
    private Object data;

    public static RequestResult succ(Object data) {

        return succ(200, "操作成功", data);
    }

    public static RequestResult succ(int code, String msg, Object data) {
        RequestResult r = new RequestResult();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static RequestResult fail(String msg) {

        return fail(400, "操作失败", null);
    }

    public static RequestResult fail(String msg, Object data) {

        return fail(400, msg, data);
    }

    public static RequestResult fail(int code, String msg, Object data) {
        RequestResult r = new RequestResult();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}
