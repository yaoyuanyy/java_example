package com.yy.poi.toturial1;

import java.util.List;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/7/31 at 下午2:35
 */
public class ExcelWritingTest {

    public static void main(String[] args) {

        ExcelMockData mockData = new ExcelMockData();
        // 20万的数据，生成的excel文件大小为90m
        List<ExcelModel> excelData = mockData.getExcelData(200000);

        ExcelWriter writer = new ExcelWriter();

        //using auto flush mode
        writer.writeToExcelAutoFlush(excelData, null);

        //using manual flush mode
        //writer.writeToExcelManualFlush(excelData);

    }
}
