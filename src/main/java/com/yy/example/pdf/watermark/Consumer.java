package com.yy.example.pdf.watermark;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020-10-29 at 15:15
 */
@Slf4j
@RequestMapping("/consumer")
@RestController()
public class Consumer {

    @RequestMapping(value = "/addWatermarkForPdf", consumes = "multipart/form-data")
    public String addWatermarkForPdf(@RequestPart("file") MultipartFile multipartFile,
                                     @RequestParam("waterMarkContent") String waterMarkContent) {
        log.info("[异步压缩并上传文件] multipartFile:{}",multipartFile);

        if (multipartFile == null) {
            log.warn("获取压缩文件失败 multipartFile == null");
            return null;
        }
        // 获取文件名称
        String fileName = this.getFileName(multipartFile);

        // 加水印耗时长，异步执行上传
        CompletableFuture.runAsync(() -> {
            // 加水印
            try {
                byte[] bytesOfPdfWithWatermark;
                Assert.isTrue(StringUtils.isNotBlank(waterMarkContent), "加水印时水印内容必须有值");
                try {
                    // 方式一
//                    String tmpdir = System.getProperty("java.io.tmpdir") + fileName;
//                    WaterMarkUtil.addWaterMarkForBytes(multipartFile.getBytes(), tmpdir, param.getWaterMarkContent());
//                    bytesOfExtHandledPdf = IOUtils.toByteArray(new FileInputStream(tmpdir));
//                    log.info("pdf加水印完成 tmpdir:{} param:{}", tmpdir, param);
//                    // 临时文件使用后删除
//                    FileUtils.delFile(tmpdir);

                    // 方式二
                    bytesOfPdfWithWatermark = WatermarkUtil.addWaterMarkForBytesNoTmpDir(multipartFile.getBytes(), waterMarkContent);
                    log.info("pdf加水印完成 waterMarkContent:{} fileName:{}", waterMarkContent, fileName);
                } catch (Exception e) {
                    log.error("加水印异常，使用原始文件操作 waterMarkContent:{} fileName:{} ERROR:", waterMarkContent, fileName, e);
                    bytesOfPdfWithWatermark = multipartFile.getBytes();
                }

                // 上传 bytesOfPdfWithWatermark

                // 发消息：上传后的url通过消息给到上游服务 fileName
            } catch (Exception e) {
            }
        });
        return fileName;
    }

    /**
     * 获取文件名称
     *
     * @param multipartFile
     * @return
     */
    private String getFileName(MultipartFile multipartFile) {
        return multipartFile.getOriginalFilename();
    }
}
