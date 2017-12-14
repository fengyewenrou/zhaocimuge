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
     * �ϴ��ļ�
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

            //������Ӧ��ǰ̨���ݵ����ݸ�ʽ
            response.setContentType("text/plain; charset=UTF-8");
            //������Ӧ��ǰ̨���ݵ�PrintWriter����
            PrintWriter out = response.getWriter();
            //�ϴ��ļ���ԭ��(���ϴ�ǰ���ļ�����)
            String originalFilename = null;
            //���ֻ���ϴ�һ���ļ�,��ֻ��ҪMultipartFile���ͽ����ļ�����,����������ʽָ��@RequestParamע��
            //������ϴ�����ļ�,��ô�����Ҫ��MultipartFile[]�����������ļ�,����Ҫָ��@RequestParamע��
            //�ϴ�����ļ�ʱ,ǰ̨���е�����<input type="file"/>��name��Ӧ����myfiles,����������myfiles�޷���ȡ�������ϴ����ļ�
            for (MultipartFile myfile : myFiles) {
                if (myfile.isEmpty()) {
//                    imagePathList.add("");
                } else {
                    originalFilename = new Date().getTime() + myfile.getOriginalFilename();
                    if(originalFilename.indexOf(".jpg")==-1) {
                        originalFilename += ".jpg";
                    }
                    logger.debug("�ļ�ԭ��: " + originalFilename);
                    logger.debug("�ļ�����: " + myfile.getName());
                    logger.debug("�ļ�����: " + myfile.getSize());
                    logger.debug("�ļ�����: " + myfile.getContentType());
                    logger.info(originalFilename);
                    try {
                        //���ﲻ�ش���IO���رյ�����,��ΪFileUtils.copyInputStreamToFile()�����ڲ����Զ����õ���IO���ص�
                        //�˴�Ҳ����ʹ��Spring�ṩ��MultipartFile.transferTo(File dest)����ʵ���ļ����ϴ�
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
                        logger.error("�ļ�[" + originalFilename + "]�ϴ�ʧ��,��ջ�켣����", e);
                    }
                }
            }
        } catch (IOException e1) {
            logger.error("", e1);
        }
        return imagePathList;
    }


}
