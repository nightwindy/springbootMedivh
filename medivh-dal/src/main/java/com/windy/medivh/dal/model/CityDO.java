package com.windy.medivh.dal.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CityDO implements Serializable {

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