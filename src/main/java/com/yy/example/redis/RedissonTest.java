package com.yy.example.redis;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-07-20 at 16:28
 */
public class RedissonTest{

//    public static void main(String[] args) {
//        RedissonTest redissonTest = new RedissonTest();
//        redissonTest.testRedissonClient();
//    }

//    public RedissonClient redissonClient() {
//        Config config = new Config();
//        config.useSingleServer().setPassword("1qaz2wsx")
//                .setAddress("redis://120.92.76.184:6379");
//        return Redisson.create(config);
//    }
//
//
//    public void testRedissonClient(){
//        RedissonClient redissonClient = redissonClient();
//        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter("phoneList");
//        bloomFilter.tryInit(100, 0.03);
//        bloomFilter.add("aaa");
//        bloomFilter.add("bbb");
//        bloomFilter.add("10086");
//
//        System.out.println(bloomFilter.contains("10086"));
//    }
}
