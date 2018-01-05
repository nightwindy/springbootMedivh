package com.windy.medivh.common.city;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by qinyisheng on 16/11/25.
 */
@Data
public class BigArea implements Serializable {

    private static final long serialVersionUID = -4912484254161498007L;

    private Integer areaId;

    private String name;

    private String remark;

    private int areaSort;
}
