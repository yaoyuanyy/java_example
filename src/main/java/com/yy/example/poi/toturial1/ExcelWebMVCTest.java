package com.yy.example.poi.toturial1;

import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/7/31 at 下午2:35
 */
@RestController
@RequestMapping("/webnvc-test")
public class ExcelWebMVCTest {

    @Resource
    private ExcelWriter excelWriter;

    @RequestMapping("/export")
    public void export(FullHttpRequest request, FullHttpResponse response) {

        ExcelMockData mockData = new ExcelMockData();
        List<ExcelModel> excelData = mockData.getExcelData(20);

        System.out.println("start =========");
        //using auto flush mode
        //excelWriter.writeToExcelAutoFlush(excelData, response);
        excelWriter.writeToExcelAsyn(response);
        System.out.println("ok ===========");
        //using manual flush mode
        //writer.writeToExcelManualFlush(excelData, response);

    }

}
