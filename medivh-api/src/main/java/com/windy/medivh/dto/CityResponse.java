package com.windy.medivh.dto;

import java.io.Serializable;

/**
 * Created by windy on 2018/1/8.
 */
public class CityResponse implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 城市编号
     * city.id
     */
    private Integer id;

    /**
     * 省份编号
     * city.province_id
     */
    private Integer provinceId;

    /**
     * 城市名称
     * city.city_name
     */
    private String cityName;

    /**
     * 描述
     * city.description
     */
    private String description;
}
