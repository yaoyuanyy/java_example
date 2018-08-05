package com.yy.example.gson;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/7/25 at 下午5:19
 */
@Data
@Builder
public class CustomerBusinessPool {
    /**
     * 主键
     */
    private Long id;

    /**
     * 商机来源
     */
    private Byte businessSource;

    /**
     * 商机状态(来电状态)
     */
    private Short connectState;

    /**
     *
     */
    private Date businessTime;

    /**
     * 租住方式
     */
    private Byte rentType;

    /**
     * 需求价位 价位最大值 TODO 我们拼好
     */
    private Integer priceUp;

    /**
     * 需求价位 价位最小值
     */
    private Integer priceDown;

    /**
     * 城市编号
     */
    private String cityCode;

    /**
     * 城区ID
     */
    private Long districtId;

    /**
     * 城区名称
     */
    private String districtName;

    /**
     * 楼盘字典商圈ID
     */
    private Long bizcircleId;

    /**
     * 楼盘字典商名称
     */
    private String bizcircleName;

    /**
     *
     */
    private Date businessTimeRecent;

    /**
     * UC ID
     */
    private Long ucId;

    /**
     * UD ID TODO
     */
    private String udId;

    private String phone;

    private String name;

    /**
     * customer_info id
     */
    private Long uuid;

    // ----------------以下非表字段-----------------

    /**
     * 城市名称
     */
    private String cityName;

}
