package com.yy.example.poi.toturial1;

import io.netty.handler.codec.http.FullHttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Component
@Slf4j
public class ExcelWriter {

    ReentrantLock lock = new ReentrantLock();

    ThreadFactory factory = new BasicThreadFactory.Builder().namingPattern("anjia-customerPool-excel-export-%d").build();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10), factory);


    CompletionService completionService = new ExecutorCompletionService(executor);

    public void asynExport(List<ExcelModel> excelModels, FullHttpResponse response) {
        executor.execute(() -> writeToExcelAutoFlush(excelModels, response));
    }

    /**
     * using auto flush and default window size 100
     *
     * @param excelModels
     * @param response
     */
    public void writeToExcelAutoFlush(List<ExcelModel> excelModels, FullHttpResponse response) {
        long start = System.currentTimeMillis();
        SXSSFWorkbook wb = null;
        OutputStream fos = null;
        try {
            // keep 100 rows in memory, exceeding rows will be flushed to disk
            wb = new SXSSFWorkbook(SXSSFWorkbook.DEFAULT_WINDOW_SIZE);
            Sheet sh = wb.createSheet();

            @SuppressWarnings("unchecked")
            Class<ExcelModel> classz = (Class<ExcelModel>) excelModels.get(0).getClass();

            Field[] fields = classz.getDeclaredFields();
            int noOfFields = fields.length;

            //int rownum = 0;
            AtomicInteger rowNum = new AtomicInteger(0);

            Row row = sh.createRow(rowNum.getAndIncrement());
            for (int i = 0; i < noOfFields; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(fields[i].getName());
            }

            for (ExcelModel excelModel : excelModels) {
                row = sh.createRow(rowNum.getAndIncrement());
                int colnum = 0;
                for (Field field : fields) {
                    String fieldName = field.getName();
                    Cell cell = row.createCell(colnum);
                    Method method = null;
                    try {
                        method = classz.getMethod("get" + ExcelUtils.capitalizeInitialLetter(fieldName));
                    } catch (NoSuchMethodException nme) {
                        method = classz.getMethod("get" + fieldName);
                    }
                    Object value = method.invoke(excelModel, (Object[]) null);
                    cell.setCellValue((String) value);
                    colnum++;
                }
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_hh_mm_ss");
            String excelFileName = "广厦_" + formatter.format(LocalDateTime.now()) + ".xlsx";
            // 浏览器附件下载
//            fos = response.getOutputStream();
//            // application/vnd.ms-excel
//            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//            // eliminates browser caching
//            response.setHeader("Expires:", "0");
//            response.setHeader("Content-disposition", "attachment; filename="+excelFileName);
//            wb.write(fos);
            System.out.println("export time:" + (System.currentTimeMillis() - start) + "毫秒");
        } catch (Exception ex) {

        } finally {
            try {
                if (fos != null) {
                    fos.flush();
                    fos.close();
                }
            } catch (IOException e) {
            }
            try {
                if (wb != null) {
                    wb.dispose();
                    wb.close();
                }
            } catch (IOException e) {
            }
        }
    }

    /**
     * using manual flush and default window size 100
     *
     * @param excelModels
     */
    public void writeToExcelManualFlush(List<ExcelModel> excelModels, FullHttpResponse response) {
        SXSSFWorkbook wb = null;
        FileOutputStream fos = null;
        try {
            // turn off auto-flushing and accumulate all rows in memory
            wb = new SXSSFWorkbook(-1);
            Sheet sh = wb.createSheet();

            @SuppressWarnings("unchecked")
            Class<ExcelModel> classz = (Class<ExcelModel>) excelModels.get(0).getClass();

            Field[] fields = classz.getDeclaredFields();
            int noOfFields = fields.length;

            int rownum = 0;
            Row row = sh.createRow(rownum);
            for (int i = 0; i < noOfFields; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(fields[i].getName());
            }

            for (ExcelModel excelModel : excelModels) {
                row = sh.createRow(rownum + 1);
                int colnum = 0;
                for (Field field : fields) {
                    String fieldName = field.getName();
                    Cell cell = row.createCell(colnum);
                    Method method = null;
                    try {
                        method = classz.getMethod("get" + fieldName);
                    } catch (NoSuchMethodException nme) {
                        method = classz.getMethod("get" + fieldName);
                    }
                    Object value = method.invoke(excelModel, (Object[]) null);
                    cell.setCellValue((String) value);
                    colnum++;
                }
                // manually control how rows are flushed to disk
                if (rownum % 100 == 0) {
                    // retain 100 last rows and flush all others
                    ((SXSSFSheet) sh).flushRows(100);
                }
                rownum++;
            }
            fos = new FileOutputStream("sxssf.xlsx");
//            // 浏览器附件下载
//            OutputStream output = response.getOutputStream();
//            response.reset();
//            response.setHeader("Content-disposition", "attachment; filename=houseids.xls");
//            response.setContentType("application/msexcel");
            wb.write(fos);
        } catch (Exception ex) {

        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
            }
            try {
                if (wb != null) {
                    wb.close();
                }
            } catch (IOException e) {
            }
        }
    }


    /**
     * @param response
     */
    public void writeToExcelAsyn(FullHttpResponse response) {
        long start = System.currentTimeMillis();
        SXSSFWorkbook wb = null;
        OutputStream fos = null;
        try {
            wb = new SXSSFWorkbook(SXSSFWorkbook.DEFAULT_WINDOW_SIZE);
            Sheet sh = wb.createSheet();

            @SuppressWarnings("unchecked")
            Class<ExcelModel> classz = ExcelModel.class;

            Field[] fields = classz.getDeclaredFields();
            int noOfFields = fields.length;

            //int rownum = 0;
            AtomicInteger rowNum = new AtomicInteger(0);
            Row row = sh.createRow(rowNum.getAndIncrement());
            for (int i = 0; i < noOfFields; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(fields[i].getName());
            }
            log.info("start write column header");

            // multi thread process
            List<ExcelModel> excelModels = this.populateTmpExcelData(20);
            for (ExcelModel excelModel : excelModels) {
                //row = sh.createRow(rowNum.getAndIncrement());
                row = getRow(sh, rowNum.getAndIncrement());
                int colnum = 0;
                for (Field field : fields) {
                    String fieldName = field.getName();
                    Cell cell = row.createCell(colnum);
                    Method method = null;
                    try {
                        method = classz.getMethod("get" + ExcelUtils.capitalizeInitialLetter(fieldName));
                    } catch (NoSuchMethodException nme) {
                        method = classz.getMethod("get" + fieldName);
                    }
                    Object value = method.invoke(excelModel, (Object[]) null);
                    cell.setCellValue((String) value);
                    colnum++;
                }
            }
            log.info("start write 前 20 columns");

            int total = 10002;
            int pageSize = 50;
            int iteratorCount = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
            List<CompletableFuture> completableFutures = new ArrayList<>(iteratorCount);

            for (int i = 0; i < iteratorCount; i++) {
                completableFutures.add(CompletableFuture.runAsync(() -> {
                    try {
                        System.out.println("jin lai le");
                        getData(sh, rowNum);
                    } catch (Exception e) {
                        log.error("export error:{}", e);
                    }
                }).handle((o, e) -> {
                    if (e != null) {
                        log.error("export error:{}", e);
                    }
                    return null;
                }));
            }

            CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).get(5, TimeUnit.MINUTES);

            log.info("异步写完数据，准备写入流中");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_hh_mm_ss");
            String excelFileName = "广厦_" + formatter.format(LocalDateTime.now()) + ".xlsx";
            // 浏览器附件下载
//            fos = response.getOutputStream();
//            // application/vnd.ms-excel
//            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//            // eliminates browser caching
//            response.setHeader("Expires:", "0");
//            response.setHeader("Content-disposition", "attachment; filename="+excelFileName);
//            wb.write(fos);
//            System.out.println("export time:" + (System.currentTimeMillis() - start) + "毫秒");
        } catch (Exception ex) {
            log.error("poi export customerPool error:{}", ex);
        } finally {
            try {
                if (fos != null) {
                    fos.flush();
                    fos.close();
                }
            } catch (IOException e) {
                log.error("fos flush close error:{}", e);
            }
            try {
                if (wb != null) {
                    wb.dispose();
                    wb.close();
                }
            } catch (IOException e) {
                log.error("wb dispose close error:{}", e);
            }
        }
    }

    public void getData(Sheet sh, AtomicInteger rowNum) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 模拟取数据
        List<ExcelModel> excelModels = this.populateTmpExcelData(50);
        Class<ExcelModel> classz = ExcelModel.class;

        Field[] fields = classz.getDeclaredFields();
        int noOfFields = fields.length;

        int localRowNum = rowNum.getAndAdd(excelModels.size());
        log.info("sheet:{} localRowNum:{}", sh, localRowNum);
        for (ExcelModel excelModel : excelModels) {
//            log.info("localRowNum:{}",localRowNum);
            Row row = getRow(sh, localRowNum++);
            int colnum = 0;
            for (Field field : fields) {
                String fieldName = field.getName();
                Cell cell = row.createCell(colnum);
                Method method = null;
                try {
                    method = classz.getMethod("get" + ExcelUtils.capitalizeInitialLetter(fieldName));
                } catch (NoSuchMethodException nme) {
                    method = classz.getMethod("get" + fieldName);
                }
                Object value = method.invoke(excelModel, (Object[]) null);
                cell.setCellValue((String) value);
                colnum++;
            }
        }
    }

    private List<ExcelModel> populateTmpExcelData(int capacity) {
        List<ExcelModel> excelModels = new ArrayList<>();
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
            excelModels.add(model);
        }
        return excelModels;
    }

    private String getRandomString() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    /**
     * 由于Sheet.createRow()使用了TreeMap(TreeMap非线程安全)，所以重写此过程，加乐观锁实现线程安全
     *
     * @param sh
     * @param rowNum
     * @return
     */
    public Row getRow(Sheet sh, int rowNum) {
        try {
            lock.lock();
            return sh.createRow(rowNum);
        } finally {
            lock.unlock();
        }

    }

}
