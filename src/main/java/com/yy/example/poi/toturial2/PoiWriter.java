package com.yy.example.poi.toturial2;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/8/1 at 上午11:42
 */

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 进行sheet写操作的sheet。
 * @author alex
 *
 */
public class PoiWriter implements Runnable {

    ReentrantLock lock = new ReentrantLock();

    private final CountDownLatch doneSignal;

    private Sheet sheet;

    private int start;

    private int end;

    public PoiWriter(CountDownLatch doneSignal, Sheet sheet, int start,
                     int end) {
        this.doneSignal = doneSignal;
        this.sheet = sheet;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        int i = start;
        try {
            while (i <= end) {
                System.out.println("row:"+i);
                Row row = getRow(sheet, i);
                Cell contentCell = row.getCell(0);
                if (contentCell == null) {
                    contentCell = row.createCell(0);
                }
                contentCell.setCellValue(i + 1);
                ++i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            doneSignal.countDown();
            System.out.println("start: " + start + " end: " + end
                    + " Count: " + doneSignal.getCount());
        }
    }

    /**
     * sheet的row使用treeMap存储的，是非线程安全的，所以在创建row时需要进行同步操作。
     * @param sheet
     * @param rownum
     * @return
     */
    private Row getRow(Sheet sheet, int rownum) {
        try{
            lock.lock();
            return sheet.createRow(rownum);
        }finally {
            lock.unlock();
        }
    }


}
