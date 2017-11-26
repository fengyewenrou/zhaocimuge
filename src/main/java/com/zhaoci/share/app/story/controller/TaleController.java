package com.zhaoci.share.app.story.controller;

import com.zhaoci.framework.base.controller.BaseController;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.framework.base.page.PageHelper;
import com.zhaoci.share.customer.service.CustomerService;
import com.zhaoci.share.story.lable.po.Lable;
import com.zhaoci.share.story.lable.service.LableService;
import com.zhaoci.share.story.tale.po.Tale;
import com.zhaoci.share.story.tale.service.TaleService;
import com.zhaoci.share.utils.ZhaoCiMessageType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by zhaoge on 2017/11/26.
 */
@Controller
@RequestMapping("app/tale")
public class TaleController extends BaseController {
    private static final Logger logger = Logger.getLogger(TaleController.class);
    @Resource
    private TaleService taleService;
    @Resource
    private LableService lableService;
    /**
     * 首页故事列表 根据创建时间、点击、评论倒序
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "taleList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String taleList(HttpServletRequest request,HttpServletResponse response){
        String message=null;
        Page<Tale> page = new Page<>();
        PageHelper.initPage(request,page);
        String pageIndex = request.getParameter("pageIndex");//页码
        String pageSize = request.getParameter("pageSize");//每页多少
        String customerId = request.getParameter("customerId");//用户ID
        if(pageSize!=null){
            page.setPageSize(Integer.parseInt(pageSize));
        }
        if(pageIndex!=null){
            page.setCurrentPage(Integer.parseInt(pageIndex));
        }
         page=  taleService.queryListPage(page);
        message = ZhaoCiMessageType.toZhaociJson("0","success","data",page.getResultList());
        return message;
    }
    @RequestMapping(value = "lableList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String lableList(HttpServletRequest request,HttpServletResponse response){
        String message=null;
        Page<Tale> page = new Page<>();
        PageHelper.initPage(request,page);
        String customerId = request.getParameter("customerId");//用户ID
        List<Lable> list=  lableService.selectList(null);
        message = ZhaoCiMessageType.toZhaociJson("0","success","data",list);
        return message;
    }
}
