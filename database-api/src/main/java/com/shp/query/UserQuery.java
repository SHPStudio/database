package com.shp.query;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: sunhaipeng
 * Date: 2018/4/4
 * Time: 16:01
 * To change this template use File | Settings | File Templates.
 */
@Data
public class UserQuery extends BaseQuery{
    private String userName;
    private String userEmail;
    private Date userBirthday;
    private String userPhone;
    private String userPassword;
}
