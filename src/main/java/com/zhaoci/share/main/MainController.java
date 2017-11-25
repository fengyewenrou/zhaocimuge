package com.zhaoci.share.main;

import com.zhaoci.framework.base.controller.BaseController;
import com.zhaoci.share.timeline.po.Timeline;
import com.zhaoci.share.timeline.service.TimelineService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kaiser on 2016/10/28.
 */
@Controller
@RequestMapping("main")
public class MainController  extends BaseController {
    private static final Logger logger = Logger.getLogger(MainController.class);
    @Resource
    private TimelineService timelineService;
    @RequestMapping("show.html")
    public ModelAndView show(HttpServletRequest request,HttpServletResponse response){
        //这是首页
        List<Timeline> list =  timelineService.selectList(null);
        for (Timeline timeline:list){
            long time = (new Date().getTime()-timeline.getCreateTime().getTime());
            long time2 =   time/(1000*60*60);
            timeline.setTimeDifference(time2);
            if(time2 == 0){
                timeline.setTimeDifference2(time/(1000*60));
            }

        }
        Map<String,Object> map = new HashMap<>();
        map.put("timeline",list);

        return new ModelAndView("timeline",map);
    }
    @RequestMapping("tinmelineadd.html")
    public void mail(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("timeline") Timeline timeline) throws IOException {
        timeline.setCreateTime(new Date());
        //timeline.setIcon("fa-file-text");
        timelineService.add(timeline);
      String  js = "<script>location.href='show.html';</script>";
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(js);
    }
    @RequestMapping("xiangqing.html")
    public ModelAndView xiangqing(HttpServletRequest request,HttpServletResponse response){

        return new ModelAndView("mail_detail");
    }
    @RequestMapping("xiexin.html")
    public ModelAndView xiexin(HttpServletRequest request,HttpServletResponse response){

        return new ModelAndView("mail_compose");
    }
    @RequestMapping("tanchuang.html")
    public ModelAndView tanchuang(HttpServletRequest request,HttpServletResponse response){

        return new ModelAndView("toastr_notifications");
    }

}
