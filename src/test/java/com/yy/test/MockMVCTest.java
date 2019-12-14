package com.yy.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Description:
 * <p></p>
 * <pre>
 *   http://niels.nu/blog/2016/spring-async-rest.html
 *   https://github.com/nielsutrecht/spring-async/blob/master/src/test/java/com/nibado/example/springasync/SimpleControllerIntegrationTest.java
 *   https://github.com/spring-projects/spring-mvc-showcase/blob/master/src/test/java/org/springframework/samples/mvc/async/CallableControllerTests.java
 * </pre>
 * <p>
 * Created by skyler on 2018/10/21 at 下午4:57
 */
//@WebAppConfiguration
//@ContextConfiguration
public class MockMVCTest extends JavaExampleAppTest {

    private MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup((WebApplicationContext) applicationContext).build();
    }

    @Test
    public void testBasic() throws Exception {
        testSync("/time/basic");
    }

    @Test
    public void testResponseEntity() throws Exception {
        testSync("/time/re");
    }

    @Test
    public void testCallable() throws Exception {
        testAsync("/time/callable");
    }

    @Test
    public void testDeferred() throws Exception {
        testAsync("/time/deferred");
    }


    private void testSync(String route) throws Exception {
        MvcResult result = mockMvc.perform(get(route))
                .andExpect(request().asyncStarted())
                .andExpect(jsonPath("$.time").isString())
                .andReturn();

        System.out.println(result);
    }

    private void testAsync(String route) throws Exception {
        MvcResult resultActions = mockMvc.perform(get(route))
                .andExpect(request().asyncStarted())
                .andReturn();

        mockMvc.perform(asyncDispatch(resultActions))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.time").isString());
    }
}
