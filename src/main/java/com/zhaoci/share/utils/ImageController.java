package com.zhaoci.share.utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhaoge on 2017/12/14.
 */
@Controller
@RequestMapping("app/image")
public class ImageController {
    private static final Logger logger = Logger.getLogger(ImageController.class);

    /**
     * 上传文件
     */
    @RequestMapping(value = "/fileUpload",produces = "application/json;charset=utf-8")
    @ResponseBody
    public static List fileUpload(
            @RequestParam(required = false) MultipartFile[] myFiles,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        List<String> imagePathList = new ArrayList<>(myFiles.length);
        try {
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

            //设置响应给前台内容的数据格式
            response.setContentType("text/plain; charset=UTF-8");
            //设置响应给前台内容的PrintWriter对象
            PrintWriter out = response.getWriter();
            //上传文件的原名(即上传前的文件名字)
            String originalFilename = null;
            //如果只是上传一个文件,则只需要MultipartFile类型接收文件即可,而且无需显式指定@RequestParam注解
            //如果想上传多个文件,那么这里就要用MultipartFile[]类型来接收文件,并且要指定@RequestParam注解
            //上传多个文件时,前台表单中的所有<input type="file"/>的name都应该是myfiles,否则参数里的myfiles无法获取到所有上传的文件
            for (MultipartFile myfile : myFiles) {
                if (myfile.isEmpty()) {
//                    imagePathList.add("");
                } else {
                    originalFilename = new Date().getTime() + myfile.getOriginalFilename();
                    if(originalFilename.indexOf(".jpg")==-1) {
                        originalFilename += ".jpg";
                    }
                    logger.debug("文件原名: " + originalFilename);
                    logger.debug("文件名称: " + myfile.getName());
                    logger.debug("文件长度: " + myfile.getSize());
                    logger.debug("文件类型: " + myfile.getContentType());
                    logger.info(originalFilename);
                    try {
                        //这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
                        //此处也可以使用Spring提供的MultipartFile.transferTo(File dest)方法实现文件的上传
                        System.out.println(System.getProperty("user.dir") + "========================");
                        String mulu =  DateUtil.getCurrDate(DateUtil.DATE_FORMAT) + "/";

						/*String path = request.getSession().getServletContext().getRealPath("/") + ( mulu);*/
                        String path ="/usr/local/nginx/html/"+"upload/"+mulu;
                        logger.debug("3========================================" + path + originalFilename);
                        FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(path, originalFilename));
                        String realPath = "/upload/"+mulu + originalFilename;
                        logger.debug("4========================================" + realPath);

                        imagePathList.add(realPath);
                    } catch (IOException e) {
                        logger.error("文件[" + originalFilename + "]上传失败,堆栈轨迹如下", e);
                    }
                }
            }
        } catch (IOException e1) {
            logger.error("", e1);
        }
        return imagePathList;
    }


}
