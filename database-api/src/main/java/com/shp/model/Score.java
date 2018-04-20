package com.shp.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Score implements Serializable{
    private Integer id;

    private Integer userId;

    private Integer chinese;

    private Integer math;

    private Integer englisth;

    private Integer computer;

    private Integer technology;

    private Integer pythsic;

}