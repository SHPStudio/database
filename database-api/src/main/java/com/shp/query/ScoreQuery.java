package com.shp.query;

import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: sunhaipeng
 * Date: 2018/4/4
 * Time: 17:54
 * To change this template use File | Settings | File Templates.
 */
@Data
public class ScoreQuery extends BaseQuery{
    private String userName;
    private String userQQ;
    private String userPhone;
    private String userEmail;
    private Date userBirthday;
}
