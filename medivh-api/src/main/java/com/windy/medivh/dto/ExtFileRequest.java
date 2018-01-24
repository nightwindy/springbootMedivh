package com.windy.medivh.dto;

import com.windy.medivh.common.model.request.BaseDubboRequest;
import lombok.Data;

/**
 * Created by chris on 2017/6/28 下午12:48.
 */
@Data
public class ExtFileRequest extends BaseDubboRequest {

    String url;

    String srcUrl;
}
