package com.meng.library.redis.param;

import com.meng.library.redis.entiy.Province;
import lombok.Data;

import java.util.List;

@Data
public class ProvinceParam {


    private String province;

    private List<Province> provinceListVo;
}
