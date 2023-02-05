package com.meng.library.redis.controller;



import com.meng.library.redis.service.ProvinceRedisService;
import com.meng.library.redis.param.ProvinceParam;
import com.meng.library.utils.base.RequestResult;
import com.meng.library.utils.constant.ResultConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/redis")
public class ProvinceController {


    @Autowired
    private ProvinceRedisService provinceRedisService;

    @RequestMapping("/editList")
    public RequestResult editList(@RequestBody List<ProvinceParam> provinceParam){
        try {
            provinceRedisService.editList(provinceParam);
            return RequestResult.succ(null);
        } catch (Exception e) {
            return RequestResult.fail(ResultConstant.ADDFAIL);
        }
    }


}
