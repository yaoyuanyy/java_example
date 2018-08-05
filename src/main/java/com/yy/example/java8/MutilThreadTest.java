package com.yy.example.java8;

import com.alibaba.fastjson.JSON;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by yaoliang on 2016/12/5.
 */
@Slf4j
public class MutilThreadTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        MutilThreadTest test = new MutilThreadTest();

        List<PersonBo> personList = test.personService(1000);

        // 方法一 76ms
//        long start1 = System.currentTimeMillis();
//        List<PersonVo> personVos1 = test.handleWithCompletableFuture(personList);
//        log.info("total handleWithCompletableFuture time:{} size:{}", System.currentTimeMillis() -start1, personVos1.size());


//         方法二 85ms
//        long start2 = System.currentTimeMillis();
//        List<PersonVo> personVos2 = test.handleWithStreamParallel(personList);
//        log.info("total handleWithStreamParallel time:{} size:{}", System.currentTimeMillis() -start2, personVos2.size());

        // 方法三 89ms
//        long start3 = System.currentTimeMillis();
//        List<PersonVo> personVos3 = test.handleWithExecutorsMethod(personList);
//        log.info("total handleWithExecutorsMethod time:{} size:{}", System.currentTimeMillis() -start3, personVos3.size());

//        // 方法四 81ms
//        long start4 = System.currentTimeMillis();
//        List<PersonVo> personVos4 = test.handleWithCompletionService(personList);
//        log.info("total handleWithCompletionService time:{} size:{}", System.currentTimeMillis() -start4, personVos4.size());


//        personList.parallelStream().forEach( o ->{
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            o.setCompany("上地数字传媒大厦-上地数字传媒大厦-上地数字传媒大厦-上地数字传媒大厦-上地数字传媒大厦");
//        });
//
//        System.out.println("main -------------------");
//        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(personList));
        //System.out.println(JSON.toJSONString(personVos2));
//        System.out.println("length:" + personVos.size());


        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2,3,4,5);
        list.parallelStream().forEach(o -> {
            System.out.println("fff"+ Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String so= o + "-aa";
            System.out.println(so);
        });

        System.out.println("main -------------------");

    }

    /**
     * 使用CompletionService.submit解析List<PersonBo>，并返回一个新的集合List<PersonVo> personVos
     *
     * @param personList
     * @return
     */
    public List<PersonVo> handleWithCompletionService(List<PersonBo> personList) {
        List<PersonVo> personVos = Collections.synchronizedList(new ArrayList<>());
        CompletionService<PersonVo> completionService = new ExecutorCompletionService(threadPoolExecutor);

        personList.forEach(vo -> {
            completionService.submit(() -> {
                try{
                    // 模拟异常
                    if(vo.getId() == 6){
                        int i = 100/0;
                    }
                    return PersonVo.builder()
                            .id(vo.getId())
                            .address(vo.getAddress())
                            .name(vo.getName())
                            .fullName(vo.getFullName())
                            .age(vo.getAge())
                            .grade(11111)
                            .school("school11")
                            .score(122)
                            .build();
                }catch (Exception e){
                    log.error("exception:{} vo:", e, vo);
                    return null;
                }
            });
        });
        for (int i=0; i<personList.size();i++) {
            try {
                PersonVo personVo = completionService.take().get();
                if(Objects.nonNull(personVo)) {
                    personVos.add(personVo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return personVos;
    }

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 20, 1, TimeUnit.SECONDS
            ,new LinkedBlockingDeque(10)
            ,new BasicThreadFactory.Builder().namingPattern("PersonService-thread-%d").build()
            ,new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 使用threadPoolExecutor.submit解析List<PersonBo>，并返回一个新的集合List<PersonVo> personVos
     * @param personList
     * @return
     */
    public List<PersonVo> handleWithExecutorsMethod(List<PersonBo> personList) {
        List<PersonVo> personVos = Collections.synchronizedList(new ArrayList<>());

        List<Future> futures = new ArrayList<>(personList.size());
        personList.forEach(vo -> {
            // 注意：此处不能使用execute(),必须用submit()
            futures.add(threadPoolExecutor.submit(() -> {
//                System.out.println("current thread:" + Thread.currentThread().getName());
                try{
                    // 模拟异常
                    if(vo.getId() == 6){
                        int i = 100/0;
                    }
                    personVos.add(PersonVo.builder()
                            .id(vo.getId())
                            .address(vo.getAddress())
                            .name(vo.getName())
                            .fullName(vo.getFullName())
                            .age(vo.getAge())
                            .grade(11111)
                            .school("school11")
                            .score(122)
                            .build());
                }catch (Exception e){
                    log.error("exception:{} vo:", e, vo);
                }
            }));
        });

        futures.forEach(f -> {
            try {
//                System.out.println("========================================" + Thread.currentThread().getName());
                f.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return personVos;
    }

    /**
     * 使用List.parallelStream解析List<PersonBo>，并返回一个新的集合List<PersonVo> personVos
     *
     * @param personList
     * @return
     */
    public List<PersonVo> handleWithStreamParallel(List<PersonBo> personList) {

        return personList.parallelStream().map(vo -> {
//            System.out.println("current thread:" + Thread.currentThread().getName());
            try{
                // 模拟异常
//                if(vo.getId() == 6){
//                    int i = 10/0;
//                }
                return PersonVo.builder()
                        .id(vo.getId())
                        .address(vo.getAddress())
                        .name(vo.getName())
                        .fullName(vo.getFullName())
                        .age(vo.getAge())
                        .grade(11111)
                        .school("school11")
                        .score(122)
                        .build();
            }catch (Exception e){
                log.error("exception:{} vo:", e, vo);
            }
            return null;
        }).filter(o -> o != null).collect(Collectors.toList());
    }

    /**
     * 使用CompletableFuture解析List<PersonBo>，并返回一个新的集合List<PersonVo> personVos
     *
     * NB. 对CompletableFuture.supplyAsync方法异常的处理，使用的是对CompletableFuture.handle方法，也可以在CompletableFuture.supplyAsync内try catch
     * @param personList
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     */
    public List<PersonVo> handleWithCompletableFuture(List<PersonBo> personList) throws InterruptedException, ExecutionException, TimeoutException {
        List<PersonVo> personVos = new ArrayList<>(personList.size());

        CompletableFuture[] futures = personList.stream().map(o -> {
            return CompletableFuture.supplyAsync(() -> {
//                try{
                    return PersonVo.builder()
                        .id(o.getId())
                        .address(o.getAddress())
                        .name(o.getName())
                        .fullName(o.getFullName())
                        .age(o.getAge())
                        .grade(11111)
                        .school("school11")
                        .score(122)
                        .build();
//                }catch (Exception e){}
//                return null;
            /**
             * handle 和 whenComplete https://dempkow.ski/blog/java-completablefuture-exception-handling/
             */
            }).handle((vo, e) -> {
                if(e == null) {
                    personVos.add(vo);
                }else {
                    log.error("exception:{} vo:", e, vo);
                }
                return null;
            });
        }).toArray(CompletableFuture[]::new);

        // 如果不使用get方法，futures返回的数据可能是不完整的，因为main可能会在某些CompletableFuture线程之前返回
        CompletableFuture.allOf(futures).get(1, TimeUnit.SECONDS);

        return personVos;
    }

    private List<PersonBo> personService(int count){
        List<PersonBo> personList = new ArrayList<>();

        for (int i = 0; i< count; i++){
            PersonBo bo = new PersonBo();
            bo.setId(Long.valueOf(i));
            bo.setName("y"+i);
            bo.setFullName("yl000000000"+i);
            bo.setAddress("bj0000000000"+i);
            bo.setAge(i*10);

            personList.add(bo);
        }
//        Collections.addAll(personList,new PersonBo(1L,"y","yl","bj",10),
//                new PersonBo(2L,"y2","yl22222222222222222","bj2222222222222222",20),
//                new PersonBo(3L,"y3","yl33333333333333333","bj33333333333333333",30),
//                new PersonBo(4L,"y4","yl444444444444444444","b4444444444444444444j",40),
//                new PersonBo(5L,"y5","yl555555555555555555","bj5555555555555555555",50),
//                new PersonBo(5L,"y5","yl555555555555555555","bj5555555555555555555",50),
//                new PersonBo(5L,"y5","yl555555555555555555","bj5555555555555555555",50),
//                new PersonBo(5L,"y5","yl555555555555555555","bj5555555555555555555",50),
//                new PersonBo(5L,"y5","yl555555555555555555","bj5555555555555555555",50),
//                new PersonBo(6L,"y5","yl555555555555555555","bj5555555555555555555",50),
//                new PersonBo(5L,"y5","yl555555555555555555","bj5555555555555555555",50),
//                new PersonBo(5L,"y5","yl555555555555555555","bj5555555555555555555",50),
//                new PersonBo(5L,"y5","yl555555555555555555","bj5555555555555555555",50),
//                new PersonBo(5L,"y5","yl555555555555555555","bj5555555555555555555",50));
        return personList;
    }



}

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
class PersonBo{
    private Long id;
    private String name;
    private String fullName;
    private String address;
    private Integer age;
    private String company;
}


@Data
@Builder
class PersonVo{
    private Long id;
    private String name;
    private String fullName;
    private String address;
    private Integer age;
    private String school;
    private Integer grade;
    private Integer score;
}
