package com.shp.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer id;

    private String userName;

    private String userPassword;

    private String userEmail;

    private Date userBirthday;

    private String userQq;

    private String userPhone;

}