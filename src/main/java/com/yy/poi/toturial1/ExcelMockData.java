package com.yy.poi.toturial1;

import com.yy.poi.toturial1.ExcelModel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class ExcelMockData {

    private List<ExcelModel> excelData;

    public ExcelMockData() {
    }

    public List<ExcelModel> getExcelData(int capacity) {
        if (excelData == null) {
            populateExcelData(capacity);
        }
        return excelData;
    }

    public void setExcelData(List<ExcelModel> excelData) {
        this.excelData = excelData;
    }

    private void populateExcelData(int capacity) {
        excelData = new ArrayList<>();
        Class<ExcelModel> classz = (Class<ExcelModel>) ExcelModel.class;
        Method[] methods = classz.getMethods();
        for (int i = 0; i < capacity; i++) {
            ExcelModel model = new ExcelModel();
            for (Method method : methods) {
                String methodName = method.getName();
                if (methodName.startsWith("set")) {
                    try {
                        method.invoke(model, getRandomString());
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            excelData.add(model);
        }
    }

    private String getRandomString() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

}
