package com.zhaoci.share.app.user.controller;

import com.zhaoci.framework.base.Constants;
import com.zhaoci.share.customer.po.Customer;
import com.zhaoci.share.customer.service.CustomerService;
import com.zhaoci.share.user.po.InviteCode;
import com.zhaoci.share.user.service.InviteCodeService;
import com.zhaoci.share.utils.MD5Util;
import com.zhaoci.share.utils.ZhaoCiMessageType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
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
    @Resource
    private InviteCodeService inviteCodeService;


   /* @RequestMapping("register")*/

    /**
     * 注册
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "register",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String register(HttpServletRequest request,HttpServletResponse response){
        String message=null;
        String version= request.getParameter("version");
        String email= request.getParameter("email");
        String password= request.getParameter("password");
        String code= request.getParameter("code");
        try {
            Customer customer1 = new Customer();
            customer1.setEmail(email);
            List<Customer> listCust =  customerService.selectList(customer1);
            if(listCust!=null&&listCust.size()>0){
            message = ZhaoCiMessageType.toZhaociJson("1", "注册失败","date","该邮箱已被注册!");
            }else {
                //邀请码是否可用
                InviteCode inviteCode = new InviteCode();
                inviteCode.setInviteCode(code);
                inviteCode.setIsUsed(Constants.TRUE);
                List<InviteCode> list = inviteCodeService.selectList(inviteCode);
                if(list!=null&&list.size()>0){
                InviteCode inviteCode1 = list.get(0);
                Customer customer = new Customer();
                customer.setEmail(email);
                customer.setPassword(MD5Util.md5(password));
                customerService.add(customer);
                List<Customer> list1  = customerService.selectList(customer);
                    //修改邀请码为已使用
                    inviteCode1.setIsUsed(Constants.FALSE);
                    inviteCodeService.update(inviteCode1);
                message = ZhaoCiMessageType.toZhaociJson("0", "注册成功","date",list1.get(0));
                }else {
                message = ZhaoCiMessageType.toZhaociJson("2", "注册失败","date","无效的邀请码!");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("数据异常：" + e.getMessage());
            message = ZhaoCiMessageType.operateToJson("3", "数据异常！");
        }

      return message;
    }

    /**
     * 登录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "login",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String login(HttpServletRequest request,HttpServletResponse response){
        String version= request.getParameter("version");
        String account= request.getParameter("account");
        String password= request.getParameter("password");
        String message=null;
        try {

        Customer customer = new Customer();
        customer.setEmail(account);
        customer.setPassword(MD5Util.md5(password));
        List<Customer> list =customerService.selectList(customer);
        if(list!=null&&list.size()>0){
            message = ZhaoCiMessageType.toZhaociJson("0", "登录成功", "data", list.get(0));
        }else {
            message = ZhaoCiMessageType.operateToJson("1", "账号或者密码错误！");
        }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("数据异常："+e.getMessage());
            message = ZhaoCiMessageType.operateToJson("2", "数据异常！");
        }
        return message;
    }

    /**
     * 修改密码
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "updateCustomerPassword",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateCustomer(HttpServletRequest request,HttpServletResponse response){
        String version= request.getParameter("version");
        String account= request.getParameter("account");
        String password= request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String message=null;
        try {
        Customer customer = new Customer();
        customer.setEmail(account);
        customer.setPassword(MD5Util.md5(password));
        List<Customer> list =customerService.selectList(customer);
        if(list!=null&&list.size()>0){
            customer = list.get(0);
            customer.setPassword(MD5Util.md5(newPassword));
            customerService.update(customer);
            message = ZhaoCiMessageType.toZhaociJson("0", "修改成功", "data", customer);
        }else {
            message = ZhaoCiMessageType.toZhaociJson("1", "无效的账号", "data", "");
        }
        }catch (Exception e){
            message = ZhaoCiMessageType.operateToJson("2", "数据异常:"+e);
        }

        return message;
    }

    /**
     * 修改头像
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "updateCustomerImage",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateCustomerImage(HttpServletRequest request,HttpServletResponse response){
        String version= request.getParameter("version");
        String account= request.getParameter("account");
        String password= request.getParameter("password");
        String imagePath= request.getParameter("imagePath");
        String message=null;
        try {
            Customer customer = new Customer();
            customer.setEmail(account);
            customer.setPassword(MD5Util.md5(password));
            List<Customer> list =customerService.selectList(customer);
            if(list!=null&&list.size()>0){
                customer = list.get(0);
                //customer.setImage(imagePath);
                customerService.update(customer);
                message = ZhaoCiMessageType.toZhaociJson("0", "修改成功", "data", customer);
            }else {
                message = ZhaoCiMessageType.toZhaociJson("1", "无效的账号", "data", "");
            }
        }catch (Exception e){
            message = ZhaoCiMessageType.operateToJson("2", "数据异常:"+e);
        }

        return message;
    }
}
