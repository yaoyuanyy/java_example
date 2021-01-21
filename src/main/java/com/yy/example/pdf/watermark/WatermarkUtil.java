package com.yy.example.pdf.watermark;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;
import java.util.UUID;

@Slf4j
public class WatermarkUtil {

    public static void main(String[] args) throws Exception {
        String sourceFile = "/Users/yaoliang/Pictures/Java开发手册（泰山版）.pdf";
        String watermarkText = "2020.10.01 领悟你的气质";

/*
        String targetFile = "/Users/yaoliang/Pictures/12.pdf";
        addWaterMark(sourceFile, targetFile, watermarkText);
*/

        // 将文件转换成字节流
/*      byte[] sourceFileBytes = IOUtils.toByteArray(new FileInputStream(sourceFile));
        addWaterMarkForBytes(sourceFileBytes ,"/Users/yaoliang/Pictures/13.pdf", watermarkText);*/

        byte[] sourceFileBytes = IOUtils.toByteArray(new FileInputStream(sourceFile));
        byte[] targetFileBytes = addWaterMarkForBytesNoTmpDir(sourceFileBytes , watermarkText);
        IOUtils.write(targetFileBytes, new FileOutputStream("/Users/yaoliang/Pictures/14.pdf"));
    }

    /**
     * 给目标pdf文件加水印，并生成新的带水印的文件
     * @param sourceFile 原目标pdf文件
     * @param targetFile 带水印的pdf文件
     * @param watermarkText 水印内容
     * @throws Exception
     */
    public static void addWaterMark(String sourceFile, String targetFile, String watermarkText) throws Exception {
        PdfStamper stamper = null;
        try{
            // 待加水印的文件
            PdfReader reader = new PdfReader(sourceFile);
            // 加完水印的文件
            stamper = new PdfStamper(reader, new FileOutputStream(targetFile));
            // 设置透明度
            PdfGState gs = new PdfGState();
            gs.setFillOpacity(0.1f);
            // 设置字体
            BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
            PdfContentByte content;
            int total = reader.getNumberOfPages() + 1;
            // 循环对每页插入水印
            for (int i = 1; i < total; i++) {
                // 水印的起始
                Rectangle box = reader.getPageSize(i);
                float maxSize = box.getHeight() > box.getWidth() ? box.getHeight() : box.getWidth();
                content = stamper.getOverContent(i);
                content.setGState(gs);
                content.setFontAndSize(base, maxSize / 50);
                // 开始
                content.beginText();
                // 设置颜色 默认为黑色
                content.setColorFill(BaseColor.BLACK);
                // 开始写入水印
                doWirteWaterMark(content, watermarkText, box.getHeight(), box.getWidth());
                content.endText();
            }
            log.info("文件加水印成功 sourceFile:{} targetFile:{}", sourceFile, targetFile);
        } catch (Exception e) {
            log.error("文件加水印异常 ERROR:", e);
        } finally {
            if (Objects.nonNull(stamper)) {
                // stamper释放了，reader随之释放
                stamper.close();
            }
        }
    }


    /**
     * 给目标pdf文件字节数组加水印，并生成新的带水印的文件
     *
     * @param sourceFileBytes 原目标pdf文件字节数组
     * @param targetFile 带水印的pdf文件
     * @param watermarkText 水印内容
     * @throws Exception
     */
    public static void addWaterMarkForBytes(byte[] sourceFileBytes, String targetFile, String watermarkText) throws Exception {
        PdfStamper stamper = null;
        try {
            long start = System.currentTimeMillis();
            // 待加水印的文件
            PdfReader reader = new PdfReader(sourceFileBytes);
            // 加完水印的文件
            stamper = new PdfStamper(reader, new FileOutputStream(targetFile));
            stamper.setFullCompression();
            // 设置透明度
            PdfGState gs = new PdfGState();
            gs.setFillOpacity(0.1f);
            // 设置中文字体
            BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
            PdfContentByte content;
            int total = reader.getNumberOfPages() + 1;
            // 循环对每页插入水印
            for (int i = 1; i < total; i++) {
                // 水印的起始
                Rectangle box = reader.getPageSize(i);
                float maxSize = box.getHeight() > box.getWidth() ? box.getHeight() : box.getWidth();
                content = stamper.getOverContent(i);
                content.setGState(gs);
                content.setFontAndSize(base, maxSize / 50);
                // 开始
                content.beginText();
                // 设置颜色 默认为黑色
                content.setColorFill(BaseColor.BLACK);
                // 开始写入水印
                doWirteWaterMark(content, watermarkText, box.getHeight(), box.getWidth());
                content.endText();
            }
            log.info("加水印成功 targetFile:{} 方法addWaterMarkForBytes执行时间花费:{}", targetFile, (System.currentTimeMillis() - start));
        } catch (Exception e) {
            log.error("文件加水印异常 ERROR:", e);
        } finally {
            if (Objects.nonNull(stamper)) {
                // stamper释放了，reader随之释放
                stamper.close();
            }
        }
    }

    /**
     * 给目标pdf文件字节数组加水印，并生成新的带水印的文件字节数组
     *
     * @param sourceFileBytes 原目标pdf文件字节数组
     * @param watermarkText 水印内容
     * @return 带水印的文件字节数组
     * @throws Exception
     */
    public static byte[] addWaterMarkForBytesNoTmpDir(byte[] sourceFileBytes, String watermarkText) throws Exception {
        PdfStamper stamper = null;
        PdfReader reader = null;
        try {
            long start = System.currentTimeMillis();
            // 待加水印的文件
            reader = new PdfReader(sourceFileBytes);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            // 加完水印的文件
            stamper = new PdfStamper(reader, byteArrayOutputStream);
            stamper.setFullCompression();
            // 设置透明度
            PdfGState gs = new PdfGState();
            gs.setFillOpacity(0.1f);
            // 设置中文字体
            BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
            // 循环对每页插入水印
            PdfContentByte content;
            int total = reader.getNumberOfPages() + 1;
            for (int i = 1; i < total; i++) {
                // 水印的起始
                Rectangle box = reader.getPageSize(i);
                float maxSize = box.getHeight() > box.getWidth() ? box.getHeight() : box.getWidth();
                content = stamper.getOverContent(i);
                content.setGState(gs);
                content.setFontAndSize(base, maxSize / 50);
                // 开始
                content.beginText();
                // 设置颜色 默认为黑色
                content.setColorFill(BaseColor.BLACK);
                // 开始写入水印
                doWirteWaterMark(content, watermarkText, box.getHeight(), box.getWidth());
                content.endText();
            }
            if (Objects.nonNull(stamper)) {
                stamper.close();
            }
            if (Objects.nonNull(reader)) {
                reader.close();
            }
            log.info("加水印成功 方法addWaterMarkForBytesNoTmpDir执行时间花费:{}", (System.currentTimeMillis() - start));
            // NOTE: byteArrayOutputStream.toByteArray()一定要在stamper.close();之后，否则byteArrayOutputStream.toByteArray()是空的
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            log.warn("文件加水印异常 ERROR:", e);
            throw new RuntimeException(e.getMessage());
        } finally {
            // 确保异常时关闭资源
            if (Objects.nonNull(stamper)) {
                stamper.close();
            }
            if (Objects.nonNull(reader)) {
                reader.close();
            }
        }
    }

    private static void doWirteWaterMark(PdfContentByte contentByte, String watermarkText, float height, float width) {
        for (int i = 0; i < height; i += height / 3) {
            for (int j = 0; j < width; j += width / 5) {
                contentByte.showTextAligned(Element.ALIGN_MIDDLE, watermarkText, i, j, 30);
            }
        }
    }


    /**
     * 添加文字水印
     *
     * @param sourceFile  待加水印文件
     * @param targetFile 加水印后输出文件
     * @throws Exception
     */
    public static void addWaterMarkImage(String sourceFile, String targetFile, String watermarkText, String imageName) throws Exception {
        // 待加水印的文件
        PdfReader reader = new PdfReader(sourceFile);
        // 加完水印的文件
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(targetFile));
        // 设置透明度
        PdfGState gs = new PdfGState();
        gs.setFillOpacity(0.1f);
        // 设置字体
        BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
        // 循环对每页插入水印
        PdfContentByte content;
        int total = reader.getNumberOfPages() + 1;
        for (int i = 1; i < total; i++) {
            // 水印的起始
            content = stamper.getOverContent(i);
            content.setGState(gs);
            Image image = Image.getInstance(imageName);
            // 设置坐标 绝对位置 X Y
            image.setAbsolutePosition(200, 300);
            // 设置旋转弧度
            image.setRotation(30);
            // 设置旋转角度
            image.setRotationDegrees(45);
            // 设置等比缩放
            image.scalePercent(90);
            // 自定义大小
            // image.scaleAbsolute(200,100);
            content.beginText();
            content.addImage(image);
            content.setFontAndSize(base, 32);
            // 设置颜色 默认为黑色
            content.setColorFill(BaseColor.BLACK);
            // 开始写入水印
            content.showTextAligned(Element.ALIGN_MIDDLE, watermarkText, 180, 340, 45);
            content.showTextAligned(Element.ALIGN_MIDDLE, UUID.randomUUID().toString(), 140, 240, 45);
            content.endText();
        }
        stamper.close();
        reader.close();
    }

}


