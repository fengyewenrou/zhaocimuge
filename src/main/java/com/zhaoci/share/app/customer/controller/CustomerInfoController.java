package com.zhaoci.share.app.customer.controller;

import com.zhaoci.framework.base.controller.BaseController;
import com.zhaoci.share.customer.service.CustomerService;
import com.zhaoci.share.utils.ZhaoCiMessageType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by kaiser on 2016/10/28.
 */
@Controller
@RequestMapping("app/customer")
public class CustomerInfoController  extends BaseController {
    private static final Logger logger = Logger.getLogger(CustomerInfoController.class);
    @Resource
    private CustomerService customerService;

    @RequestMapping("customerList/{version}/{summary}")
    public void customerList(@PathVariable String version, HttpServletRequest request,HttpServletResponse response){
            List list=customerService.selectList(null);
        String message = ZhaoCiMessageType.toZhaociJson("0", "查询成功", "data", list);
        PrintWriter out;
        response.setContentType("text/html;charset=UTF-8");
        try {
            out = response.getWriter();
            out.print(message);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("",e);
        }
    }
    @RequestMapping("customerListV2")
    public void customerList1(HttpServletRequest request,HttpServletResponse response){
      String version= request.getParameter("version");
        String message=null;
        if(version.equals("1.0")){
            List list=customerService.selectList(null);
            message = ZhaoCiMessageType.toZhaociJson("0", "查询成功", "data", list);
        }else {
            message = ZhaoCiMessageType.toZhaociJson("1", "查询失败", "data", "版本错误");
        }

        PrintWriter out;
        response.setContentType("text/html;charset=UTF-8");
        try {
            out = response.getWriter();
            out.print(message);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("",e);
        }
    }



}
