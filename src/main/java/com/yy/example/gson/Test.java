package com.yy.example.gson;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/7/27 at 下午6:48
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.orgCHQ();
    }

    public void orgCBP(){
        List list = new ArrayList(){{
            add(1);
            add(2);
            add(3);
        }};

        System.out.println(JSON.toJSONString(list));

        CustomerBusinessPool pool1 = CustomerBusinessPool.builder()
                .id(11L)
                .businessSource((byte)1)
                .connectState((short)1)
                .businessTime(new Date())
                .rentType((byte)1)
                .priceUp(11111)
                .priceDown(1100)
                .cityName("bei京")
                .districtName("东城区")
                .bizcircleName("回龙观")
                .ucId(111111L)
                .udId("sewrew1111")
                .phone("13000009999")
                .name("zhangsan").build();

        CustomerBusinessPool pool2 = CustomerBusinessPool.builder()
                .id(112L)
                .businessSource((byte)1)
                .connectState((short)2)
                .businessTime(new Date())
                .rentType((byte)1)
                .priceUp(2432434)
                .priceDown(11300)
                .cityName("bei京")
                .districtName("东城区")
                .bizcircleName("回龙观")
                .ucId(111111L)
                .udId("sewrew11sefs11")
                .phone("13000009990")
                .name("zhangsan").build();

        Map<String,CustomerBusinessPool> map = new HashMap<>();
        map.put(pool1.getId()+"", pool1);
        map.put(pool2.getId()+"", pool2);

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(map));
    }

    public void orgCHQ(){
        DistributedHouseQuery query = new DistributedHouseQuery();
        query.setActivityCode("dsfdsfdsfd活动活动");
        query.setBusinessCode("b商家商家sdfdsf大幅度");

        List<DistributedHouseQuery.DistributedHouse> list = new ArrayList();
        IntStream.range(0,5000).forEach(i -> {
            DistributedHouseQuery.DistributedHouse house = new DistributedHouseQuery.DistributedHouse();
            house.setCouponTemplateId(Long.valueOf(i));
            house.setRentUnitCode("1100000001063364" + i);
            list.add(house);
        });
        query.setList(list);

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(query));
    }
}
