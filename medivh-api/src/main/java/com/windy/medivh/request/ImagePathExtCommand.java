package com.windy.medivh.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImagePathExtCommand implements Serializable {

    private static final long serialVersionUID = 1L;

    @NonNull
    Long fileId;

    int weight =200;

    int height =200;

    /**
     * 0-100
     */
    int quality = 75;

    /**
     * 自己七牛找好了,不知道就默认
     */
    int clipMode = 0;


}
