package com.shp.query;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: sunhaipeng
 * Date: 2018/4/4
 * Time: 16:02
 * To change this template use File | Settings | File Templates.
 */
@Data
public class BaseQuery implements Serializable {
    private int pageIndex = 1;
    private int pageSize = 20;
}
