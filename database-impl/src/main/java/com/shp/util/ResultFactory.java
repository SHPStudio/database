package com.shp.util;

import com.shp.Contant.ResultEnum;
import com.shp.result.BaseResult;

/**
 * Created by IntelliJ IDEA.
 * User: sunhaipeng
 * Date: 2018/4/4
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class ResultFactory {

    public static BaseResult getErrorResult(ResultEnum resultEnum) {
        return new BaseResult(resultEnum.getCode(), resultEnum.getMessage());
    }
}
