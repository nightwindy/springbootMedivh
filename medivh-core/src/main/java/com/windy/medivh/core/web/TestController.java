package com.windy.medivh.core.web;

import com.alibaba.dubbo.common.json.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {


    @GetMapping("/hi")
    public String getCalculateResult() throws ParseException {
        return "计算成功";
    }


}
