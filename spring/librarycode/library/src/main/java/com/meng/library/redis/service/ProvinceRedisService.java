package com.meng.library.redis.service;


import com.alibaba.fastjson.JSONObject;
import com.meng.library.redis.param.ProvinceParam;
import com.meng.library.utils.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProvinceRedisService {

    @Autowired
    private RedisUtil redisUtil;

    public void editList(List<ProvinceParam> provinceParam) {

        List<ProvinceParam> listBase = new ArrayList<>();
        //遍历provinceParam
        provinceParam.forEach(e -> {
            //存到对应的字段
            ProvinceParam provinceParams = new ProvinceParam();
            //省份
            provinceParams.setProvince(e.getProvince());
            //区号/城市名
            provinceParams.setProvinceListVo(e.getProvinceListVo());
            //保存new的List
            listBase.add(provinceParams);
        });
        //插入redis数据库
        redisUtil.set("福建省", JSONObject.toJSONString(listBase));
    }
}
