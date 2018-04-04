package com.shp.query;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: sunhaipeng
 * Date: 2018/4/4
 * Time: 16:02
 * To change this template use File | Settings | File Templates.
 */
@Data
public class BaseQuery {
    private int pageIndex = 1;
    private int pageSize = 20;
}
