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
public class Province implements Serializable {

    private static final long serialVersionUID = -6791252943001301194L;

    @Getter
    @Setter
    private Integer proId;

    @Getter
    @Setter
    private String remark;

    @Getter
    @Setter
    private int proSort;

    @Getter
    @Setter
    private Integer areaId;

    private String name;

    private String shortName;

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
        if (StringUtils.isBlank(name)) {
            return;
        }
        if (name.endsWith("省") || name.endsWith("市")) {
            shortName = name.substring(0, name.length() - 1);
        }
        if (name.endsWith("自治区")) {
            shortName = name.substring(0, name.length() - 3);
        }
        if (name.endsWith("特别行政区") || name.endsWith("族自治区")) {
            shortName = name.substring(0, name.length() - 5);
        }
        if (shortName.length() > 5) {
            shortName = shortName.substring(0, 5) + "...";
        }
        this.shortName = shortName;
    }
}
