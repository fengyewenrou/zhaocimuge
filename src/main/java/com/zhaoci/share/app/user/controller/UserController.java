package com.zhaoci.share.app.user.controller;

import com.zhaoci.share.customer.po.Customer;
import com.zhaoci.share.customer.service.CustomerService;
import com.zhaoci.share.utils.ZhaoCiMessageType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Copyright (C), 2002-2017, 朝辞
 * FileName: UserController
 * Author:   fanfuchen
 * Date:     2017/10/17 14:49
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
@Controller
@RequestMapping("app/customer")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Resource
    private CustomerService customerService;



   /* @RequestMapping("register")*/
    @RequestMapping(value = "register",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String register(HttpServletRequest request,HttpServletResponse response){
        String version= request.getParameter("version");
        String account= request.getParameter("account");
        String password= request.getParameter("password");
        String code= request.getParameter("code");
        String message=null;
        Customer customer = new Customer();
        customer.setEmail(account);
        customer.setName(account);
        customerService.add(customer);
        message = ZhaoCiMessageType.operateToJson("0", "注册成功");
      return message;
    }
    @RequestMapping(value = "login",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String login(HttpServletRequest request,HttpServletResponse response){
        String version= request.getParameter("version");
        String account= request.getParameter("account");
        String password= request.getParameter("password");
        String message=null;
        Customer customer = new Customer();
        customer.setEmail(account);
        customer.setName(account);
        List<Customer> list =customerService.selectList(customer);
        if(list!=null&&list.size()>0){
            message = ZhaoCiMessageType.toZhaociJson("0", "登录成功", "data", list.get(0));
        }else {
            message = ZhaoCiMessageType.operateToJson("1", "账号或者密码错误！");
        }
        return message;
    }
}
