//package com.yy.rest.down_pdf_image;
//
//import com.yy.util.DateUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.io.IOUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.context.ServletContextAware;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.Date;
//
//import static java.nio.charset.StandardCharsets.UTF_8;
//
///**
// * Description: 数据byte[]转化为浏览器下载的附件：pdf、image等的几种方式
// * <pre>
// *  本文文件(pdf/image等)转换成数据流在转换成浏览器下载的附件：pdf、image
// *
// *  大部分都是利用restTemplate，只有一个使用HttpServletResponse结合servletContext完成
// *
// *  参考：
// *  https://www.baeldung.com/spring-mvc-image-media-data
// *  https://www.mkyong.com/java/how-to-convert-array-of-bytes-into-file/
// * </pre>
// * <p>
// * Created by skyler on 2019-03-27 at 10:28
// */
//@Slf4j
//@Controller
//@RequestMapping("/pdf-image-response")
//public class ResponsePDFImageController implements ServletContextAware {
//
//    private ServletContext servletContext;
//    @Override
//    public void setServletContext(ServletContext servletContext) {
//        this.servletContext = servletContext;
//    }
//
//    /**
//     * NB. 这种方式适合war项目，不适合springboot jar project. aspect.png should be in src/main/webapp/picture/aspect.png
//     * , not src/main/resources
//     *
//     * ServletContext.getResourceAsStream for accessing resources in WARs or ClassLoader.getResourceAsStream for accessing resources in JARs
//     *
//     * @param response
//     * @throws IOException
//     */
//    @RequestMapping("/image-as-byteArray")
//    public void getImageAsByteArray(HttpServletResponse response) throws IOException {
//
//        // TODO this.getClass().getClassLoader().getResourceAsStream()加载原理与坑
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("picture/aspect.png");
//        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//        IOUtils.copy(in, response.getOutputStream());
//    }
//
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//
//    //-----------------------\
//    //        pdf下载        |
//    //-----------------------/
//    /**
//     * 利用 ResponseEntity实现pdf浏览器下载
//     *
//     * 假设：
//     * 服务器返回的响应头如下：
//     *
//     * HTTP/1.1 200 OK Cache-Control: max-age=0,must-revalidate
//     * Content-Disposition: attachment; filename=”Executive Summary.PDF”
//     * Content-Type: application/pdf
//     *
//     * 针对响应头，client端的restTemplate需要适配响应头的解析
//     *
//     * @param response
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping("/download")
//    public ResponseEntity<byte[]> download(HttpServletResponse response) throws IOException {
//        // 从github上下载：你的灯还亮着吗-有图版.pdf
//        String url = "https://github.com/yaoyuanyy/books/blob/master/%E3%80%8A%E4%BD%A0%E7%9A%84%E7%81%AF%E8%BF%98%E4%BA%AE%E7%9D%80%E5%90%97%E3%80%8B%E6%9C%89%E5%9B%BE%E7%89%88.pdf";
//
//        log.info("url:{}", url);
//        byte[] result = restTemplate.getForObject(url, byte[].class);
//
//        // byte[]数据给浏览器
//        HttpHeaders headers = new HttpHeaders();
//        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
//        headers.setContentType(new MediaType("application", "pdf", UTF_8));
//        // headers.add("content-disposition", "attachment; filename=" + DateUtil.DateToString(new Date(),"yyyyMMddHHmmss") + instanceId + (isSeal?"seal.pdf":"noseal.pdf"));
//        headers.setContentDispositionFormData("attachment", DateUtil.formatWithJava8(new Date()) + ".pdf");
//        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(result, headers, HttpStatus.OK);
//        return responseEntity;
//
//    }
//
//    /**
//     * 利用 @ResponseBody实现pdf浏览器下载
//     *
//     * @param response
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping("/download2")
//    @ResponseBody
//    public void download2(HttpServletResponse response) throws IOException {
//
//        // 从github下载技术学习规划表.pdf
//        String url = "https://github.com/yaoyuanyy/books/blob/master/2019-03-19_%E6%8A%80%E6%9C%AF%E5%AD%A6%E4%B9%A0%E8%A7%84%E5%88%92%E8%A1%A8.pdf";
//
//        log.info("url:{}", url);
//        byte[] result = restTemplate.getForObject(url, byte[].class);
//
//        response.setContentType("application/pdf");
//        response.addHeader("Content-Disposition", "attachment; filename=" + DateUtil.formatWithJava8(new Date()) + ".pdf");
//
//        response.getOutputStream().write(result);
//
//    }
//
//    /**
//     * 利用 @ResponseBody实现pdf浏览器下载
//     *
//     * @param response
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping("/download3")
//    @ResponseBody
//    public byte[] download3(HttpServletResponse response) throws IOException {
//
//        // 从github下载技术学习规划表.pdf
//        String url = "https://github.com/yaoyuanyy/books/blob/master/2019-03-19_%E6%8A%80%E6%9C%AF%E5%AD%A6%E4%B9%A0%E8%A7%84%E5%88%92%E8%A1%A8.pdf";
//
//        log.info("url:{}", url);
//        byte[] result = restTemplate.getForObject(url, byte[].class);
//
//        response.setContentType("application/octet-stream");
//        response.addHeader("Content-Disposition", "attachment; filename=" + DateUtil.formatWithJava8(new Date()) + ".pdf");
//
//        return result;
//
//    }
//
//
//    //---------------------------------------\
//    //     网上jpg/png图片通过浏览器附件下载     |
//    //---------------------------------------/
//
//    /**
//     * 利用@ResponseBody结合response.setContentType/response.addHeader通过浏览器下载图片
//     * @param response
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping("/download4")
//    @ResponseBody
//    public byte[] download4(HttpServletResponse response) throws IOException {
//
//        String imageUrl = "https://github.com/yaoyuanyy/gitbook/blob/gh-pages/pic/19.jpg?raw=true";
//
//        log.info("imageUrl:{}", imageUrl);
//        byte[] result = restTemplate.getForObject(imageUrl, byte[].class);
//
//        response.setContentType("application/octet-stream");
//        response.addHeader("Content-Disposition", "attachment; filename=" +DateUtil.formatWithJava8(new Date()) + ".png");
//
//        return result;
//
//    }
//
//
//    //--------------------------------\
//    //     网上jpg/png图片下载到本地     |
//    //--------------------------------/
//
//    /**
//     * 使用restTemplate下载jpg图片，通过nio/普通方式下载图片到本地google2.png
//     *
//     * 参考： https://www.mkyong.com/java/how-to-convert-array-of-bytes-into-file/
//     *
//     * @throws IOException
//     */
//    @RequestMapping("/download5")
//    public void down() throws IOException {
//        String imageUrl = "https://github.com/yaoyuanyy/gitbook/blob/gh-pages/pic/19.jpg?raw=true";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
//
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        ResponseEntity<byte[]> response = restTemplate.exchange(imageUrl, HttpMethod.GET, entity, byte[].class);
//
//        if (response.getStatusCode() == HttpStatus.OK) {
//            // 使用nio方式
//            Path path = Files.write(Paths.get("google2.png"), response.getBody());
//            log.info("image path:{}", path.toUri().getPath());
//
//            // 使用普通方式
////            OutputStream stream = new FileOutputStream("google2.png");
////            stream.write(response.getBody());
////            stream.flush();
////            stream.close();
//        }
//    }
//
//}
