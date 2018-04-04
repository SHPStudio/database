package com.shp.Contant;

/**
 * Created by IntelliJ IDEA.
 * User: sunhaipeng
 * Date: 2018/4/4
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */
public enum ResultEnum {
    SUCCESS(0,""),
    SYSTEM_ERROR(-1,"系统错误"),
    QUERY_NULL(-2,"查询对象为空"),
    ID_NULL(-3,"ID不能为空"),
    INSERT_PARAM_NULL(-4, "插入对象不能为空"),
    NAME_PASSWORD_NULL(-5, "用户名或密码不能为空"),
    USER_ID_NULL(-6,"用户ID不能为空"),
    REPEAT_INSERT(-7, "重复插入"),
    UPDATE_PARAM_NULL(-8, "更新对象不能为空");


    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
