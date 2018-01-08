package com.windy.medivh.common.city;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Created by qinyisheng on 16/11/25.
 */
@ToString
public class City implements Serializable {

    private static final long serialVersionUID = 4559475849688573675L;

    @Getter
    @Setter
    private Integer cityId;

    @Getter
    @Setter
    private Integer proId;

    @Getter
    @Setter
    private int citySort;

    private String shortName;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setShortName(name);
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String name) {
        String shortName = name;
        if (!StringUtils.isBlank(name) && name.endsWith("市")) {
            shortName = name.substring(0, name.length() - 1);
        }
        if (shortName.length() > 4) {
            shortName = shortName.substring(0, 4) + "...";
        }
        this.shortName = shortName;
    }
}
