package com.zhaoci.share.app.story.controller;

import com.zhaoci.framework.base.Constants;
import com.zhaoci.framework.base.controller.BaseController;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.framework.base.page.PageHelper;
import com.zhaoci.share.customer.service.CustomerService;
import com.zhaoci.share.story.lable.po.Lable;
import com.zhaoci.share.story.lable.service.LableService;
import com.zhaoci.share.story.po.Comment;
import com.zhaoci.share.story.po.StoryType;
import com.zhaoci.share.story.service.CommentService;
import com.zhaoci.share.story.service.StoryTypeService;
import com.zhaoci.share.story.tale.po.Tale;
import com.zhaoci.share.story.tale.service.TaleService;
import com.zhaoci.share.user.po.InviteCode;
import com.zhaoci.share.user.service.InviteCodeService;
import com.zhaoci.share.utils.DateUtil;
import com.zhaoci.share.utils.ZhaoCiMessageType;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.*;

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
    @Resource
    private CommentService commentService;
    @Resource
    private StoryTypeService storyTypeService;
    @Resource
    private InviteCodeService inviteCodeService;
    /**
     * 首页故事列表 根据创建时间、点击、评论倒序
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "taleList", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String taleList(HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        try {
            Page<Tale> page = new Page<>();
            PageHelper.initPage(request, page);
            String pageIndex = request.getParameter("pageIndex");//页码
            String pageSize = request.getParameter("pageSize");//每页多少
            String customerId = request.getParameter("customerId");//用户ID
            if (pageSize != null) {
                page.setPageSize(Integer.parseInt(pageSize));
            }
            if (pageIndex != null) {
                page.setCurrentPage(Integer.parseInt(pageIndex));
            }
            page = taleService.queryListPage2(page);
            message = ZhaoCiMessageType.toZhaociJson("0", "success", "data", page.getResultList());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            message = ZhaoCiMessageType.toZhaociJson("1", "fail", "data","");
        }
        return message;
    }

    /**
     * 我喜欢的列表  type 应为2 收藏为1
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "taleListLike", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String taleListLike(HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        try {
            Page<Tale> page = new Page<>();
            PageHelper.initPage(request, page);
            String pageIndex = request.getParameter("pageIndex");//页码
            String pageSize = request.getParameter("pageSize");//每页多少
            String customerId = request.getParameter("customerId");//用户ID
            String type = request.getParameter("type");//类型
            if (pageSize != null) {
                page.setPageSize(Integer.parseInt(pageSize));
            }
            if (pageIndex != null) {
                page.setCurrentPage(Integer.parseInt(pageIndex));
            }
            page.getParams().put("customerId",customerId);
            page.getParams().put("type",type);
            page = taleService.queryListPage2(page);
            message = ZhaoCiMessageType.toZhaociJson("0", "success", "data", page.getResultList());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            message = ZhaoCiMessageType.toZhaociJson("1", "fail", "data","");
        }
        return message;
    }

    /**
     * 标签列表
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "lableList", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String lableList(HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        try {
        String customerId = request.getParameter("customerId");//用户ID
        Lable lable = new Lable();
        lable.setIsUsed(Constants.TRUE);
        List<Lable> list = lableService.selectList(lable);
        message = ZhaoCiMessageType.toZhaociJson("0", "success", "data", list);
        }catch (Exception e){
            e.printStackTrace();
            message = ZhaoCiMessageType.toZhaociJson("1", "fail", "data","");
        }

        return message;
    }
    /**
     * 类型列表
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "typeList", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String typeList(HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        String customerId = request.getParameter("customerId");//用户ID
        try {
        StoryType storyType = new StoryType();
        storyType.setIsUsed(Constants.TRUE);
        List<StoryType> list = storyTypeService.selectList(storyType);
        message = ZhaoCiMessageType.toZhaociJson("0", "success", "data", list);
        }catch (Exception e){
            e.printStackTrace();
            message = ZhaoCiMessageType.toZhaociJson("1", "fail", "data","");
        }
        return message;
    }
    /**
     * 增加故事
     *
     * @param request
     * @param response
     * @param tale
     * @return
     */
    @RequestMapping(value = "insertTale", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insertTale(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Tale tale) {
        String message = null;
        try {
            taleService.insertTale(tale);
            message = ZhaoCiMessageType.toZhaociJson("0", "success", "data", tale);
        }catch (Exception e){
            e.printStackTrace();
            message = ZhaoCiMessageType.toZhaociJson("1", "fail", "data","");
        }

        return message;
    }

    /**
     * 增加评论
     *
     * @param request
     * @param response
     * @param comment
     * @return
     */
    @RequestMapping(value = "insertComment", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insertComment(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Comment comment) {
        String message = null;
        try {
        commentService.add(comment);
        Tale tale = taleService.queryById(comment.getTaleId());
        message = ZhaoCiMessageType.toZhaociJson("0", "success", "data", tale);
        }catch (Exception e){
            e.printStackTrace();
            message = ZhaoCiMessageType.toZhaociJson("1", "fail", "data","");
        }
        return message;
    }

    /**
     * 评论列表
     *
     * @param request
     * @param response
     * @param id
     * @return
     */
    @RequestMapping(value = "commentList", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String commentList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer id) {
        String message = null;
        try{
        Comment comment = new Comment();
        comment.setTaleId(id);
        List<Comment> list = commentService.selectList(comment);
        message = ZhaoCiMessageType.toZhaociJson("0", "success", "data", list);
        }catch (Exception e){
            e.printStackTrace();
            message = ZhaoCiMessageType.toZhaociJson("1", "fail", "data","");
        }
        return message;
    }

    /**
     * 单个故事带评论
     * @param request
     * @param response
     * @param
     * @return
     */
    @RequestMapping(value = "queryTale", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryTale(HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        String id = request.getParameter("id");
        try{
        Map<String,Object> map= taleService.queryById2(Integer.parseInt(id));
        message = ZhaoCiMessageType.toZhaociJson("0", "success", "data", map);
        }catch (Exception e){
            e.printStackTrace();
            message = ZhaoCiMessageType.toZhaociJson("1", "fail", "data","");
        }
        return message;
    }

    /**
     * 今日推荐  只展示5条标题和名字
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "todatRecommend", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String todatRecommend(HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        try {
            List<Map<String, Object>> mapList = new ArrayList<>();
            List<Tale> list = taleService.todatRecommend(DateUtil.getCurrDate(DateUtil.DATE_FORMAT));
            message = ZhaoCiMessageType.toZhaociJson("0", "success", "data", list);
        }catch (Exception e){
            e.printStackTrace();
            message = ZhaoCiMessageType.toZhaociJson("1", "fail", "data","");
        }
        return message;
    }

    /**
     * 生成邀请码
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "createInviteCode", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String createInviteCode(HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        String customerId = request.getParameter("customerId");
        try{
        InviteCode inviteCode = new InviteCode();
        inviteCode.setIsUsed(Constants.TRUE);
        inviteCode.setCreateUser(customerId);
        inviteCode.setInviteCode(this.getStringRandom(8));
        inviteCode.setCreateDate(DateUtil.getCurrDate(DateUtil.DATE_FORMAT));
        inviteCodeService.add(inviteCode);
        message = ZhaoCiMessageType.toZhaociJson("0", "success", "data", inviteCode);
        }catch (Exception e){
            e.printStackTrace();
            message = ZhaoCiMessageType.operateToJson("1","数据异常！");
        }
        return message;
    }

    //生成随机数字和字母,
    private String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}
