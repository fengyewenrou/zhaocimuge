package com.zhaoci.share.story.controller;

import com.zhaoci.framework.base.Constants;
import com.zhaoci.framework.base.controller.BaseController;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.framework.base.page.PageHelper;
import com.zhaoci.share.story.lable.po.Lable;
import com.zhaoci.share.story.lable.service.LableService;
import com.zhaoci.share.story.po.StoryType;
import com.zhaoci.share.story.service.StoryTypeService;
import com.zhaoci.share.user.po.Menu;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoge on 2017/12/8. 后台 标签分类列表
 */
@Controller
@RequestMapping("tale")
public class TaleListController  extends BaseController {
    private static final Logger logger = Logger.getLogger(TaleListController.class);
    @Resource
    private LableService lableService;
    @Resource
    private StoryTypeService storyTypeService;

    @RequestMapping("lable/list.html")
    public ModelAndView lableList(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map=new HashMap();
        try{
            request.setCharacterEncoding("UTF-8");
			/*查询列表*/
            Page<Lable> page = new Page<>();
            PageHelper.initPage(request, page);
            page.setParams(super.getParamMap(request));
            page.getParams().put("isUsed", Constants.TRUE);
            page = lableService.queryListPage(page);
            PageHelper.setPageModel(request, page);

        }catch(Exception e){
            e.printStackTrace();
            logger.error("进入客户信息列表页出现异常",e);
        }
        return new ModelAndView("tale/lable_list");
    }
    @RequestMapping("type/list.html")
    public ModelAndView typeList(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map=new HashMap();
        try{
            request.setCharacterEncoding("UTF-8");
			/*查询列表*/
            Page<StoryType> page = new Page<>();
            PageHelper.initPage(request, page);
            page.setParams(super.getParamMap(request));
            page.getParams().put("isUsed", Constants.TRUE);
            page = storyTypeService.queryListPage(page);
            PageHelper.setPageModel(request, page);

        }catch(Exception e){
            e.printStackTrace();
            logger.error("进入客户信息列表页出现异常",e);
        }
        return new ModelAndView("tale/story_type_list");
    }


}
