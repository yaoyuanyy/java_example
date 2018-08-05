package com.yy.poi.toturial1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public void export(HttpServletRequest request, HttpServletResponse response) {

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

    @RequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("quering ----");

    }
}
