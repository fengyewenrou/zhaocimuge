package com.zhaoci.share.page;

import com.zhaoci.framework.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lx on 2016/11/25.
 */
@Controller
@RequestMapping("frame")
public class PageController extends BaseController {
    @RequestMapping("page.html")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("frame/page_v2");
    }
}
