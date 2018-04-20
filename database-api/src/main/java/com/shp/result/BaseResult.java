package com.shp.result;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: sunhaipeng
 * Date: 2018/4/4
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
@Data
public class BaseResult<T> implements Serializable {
    private int resultCode;
    private String errorMessage;
    private T data;

    public static BaseResult SUCCESS = new BaseResult(0);

    public BaseResult(int resultCode,String errorMessage) {
        this.errorMessage = errorMessage;
        this.resultCode = resultCode;
    }

    public BaseResult(int resultCode, T data) {
        this.resultCode = resultCode;
        this.data = data;
    }

    public BaseResult(int resultCode) {
        this.resultCode = resultCode;
    }
}
