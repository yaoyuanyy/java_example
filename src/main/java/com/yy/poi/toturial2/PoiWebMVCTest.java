package com.yy.poi.toturial2;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/8/1 at 上午11:22
 */
@RestController
@RequestMapping("poi-export")
@Slf4j
public class PoiWebMVCTest {

    ReentrantLock lock = new ReentrantLock();

    ThreadFactory factory = new BasicThreadFactory.Builder().namingPattern("customerPool-excel-export-%d").build();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10), factory);

    ThreadFactory factory2 = new BasicThreadFactory.Builder().namingPattern("anjia-customerPool-%d").build();
    ThreadPoolExecutor executor2 = new ThreadPoolExecutor(3, 5, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10), factory2);

    /**
     * 使用多线程进行Excel写操作，提高写入效率。
     */
    @RequestMapping("/multiThreadWrite")
    public void multiThreadWrite(HttpServletRequest request, HttpServletResponse response) {
        executor2.execute(() -> {
            long start = System.currentTimeMillis();

            int total = 52;
            int pageSize = 10;
            int iteratorCount = total%pageSize == 0 ? total/pageSize: total/pageSize + 1;

            CountDownLatch doneSignal = new CountDownLatch(iteratorCount);

            SXSSFWorkbook wb = null;
            OutputStream fos = null;
            AtomicInteger rowNum = new AtomicInteger(0);

            try {
                // keep 100 rows in memory, exceeding rows will be flushed to disk
                wb = new SXSSFWorkbook(SXSSFWorkbook.DEFAULT_WINDOW_SIZE);
                Sheet sheet = wb.createSheet("test_skyler");
                for (int i = 0; i < iteratorCount; i++) {
                    executor.submit(new PoiWriter(doneSignal, sheet, rowNum.incrementAndGet(), (i == iteratorCount -1 ? total%pageSize : rowNum.addAndGet(pageSize))));
                }
                /**
                 * 使用CountDownLatch的await方法，等待所有线程完成sheet操作
                 */
                doneSignal.await();

                log.info("异步写完数据，准备写入流中");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_hh_mm_ss");
                String excelFileName = "toturial_测试_" + formatter.format(LocalDateTime.now()) + ".xlsx";
                // 浏览器附件下载
                fos = response.getOutputStream();
                // application/vnd.ms-excel
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                // eliminates browser caching
                response.setHeader("Expires:", "0");
                response.setHeader("Content-disposition", "attachment; filename="+excelFileName);
                log.info("fos:"+fos+" wb:"+wb);
                wb.write(fos);
                System.out.println("export time:" + (System.currentTimeMillis() - start) + "毫秒");

            } catch (Exception e) {
                log.error("poi-export error:{}", e);
                e.printStackTrace();
            }finally {
                try {
                    if (fos != null) {
                        fos.flush();
                        fos.close();
                    }
                } catch (IOException e) {
                    log.error("fos flush close error:{}",e);
                }
                try {
                    if (wb != null) {
                        wb.dispose();
                        wb.close();
                    }
                } catch (IOException e) {
                    log.error("wb dispose close error:{}",e);
                }
            }
        });

    }
}

