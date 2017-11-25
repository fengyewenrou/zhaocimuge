package com.zhaoci.share.customer.controller;

import com.zhaoci.framework.base.controller.BaseController;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.framework.base.page.PageHelper;
import com.zhaoci.share.customer.po.Customer;
import com.zhaoci.share.customer.service.CustomerService;
import com.zhaoci.share.main.ExportExcel;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kaiser on 2016/10/28.
 */
@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {

    private static final Logger logger = Logger.getLogger(CustomerController.class);
    @Resource
    private CustomerService customerService;

    @RequestMapping("list.html")
    public ModelAndView show(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map=new HashMap();
        try{
            request.setCharacterEncoding("UTF-8");
			/*查询列表*/
            Page<Customer> page = new Page<>();
            PageHelper.initPage(request, page);
             page.setParams(super.getParamMap(request));
            page = customerService.queryListPage(page);
            PageHelper.setPageModel(request, page);

        }catch(Exception e){
            e.printStackTrace();
            logger.error("进入客户信息列表页出现异常",e);
        }
        return new ModelAndView("customer/customer_list");
    }

    /**
     * 导出优惠券发放记录excel文档
     */
    @RequestMapping("excelCustomerList.html")
    public void excelRecharge(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            Map<String, String> map = new HashMap<>();
            map.put("name",request.getParameter("name")); // 客户名称
            map.put("phone",request.getParameter("phone")); // 电话
            map.put("email",request.getParameter("email")); // email
            final List<Customer> list =  customerService.queryListByExcel(map);
            if (list != null && list.size() > 0) {
                ExportExcel.exportExcel(new ExportExcel.ExcelObject() {
                    @Override
                    public void dataSource(WritableSheet sheet, WritableCellFormat wcf_center, WritableCellFormat wcf_left) throws Exception {
                        sheet.addCell(new Label(0, 0, "名称", wcf_center));
                        sheet.addCell(new Label(1, 0, "性别", wcf_center));
                        sheet.addCell(new Label(2, 0, "年龄", wcf_center));
                        sheet.addCell(new Label(3, 0, "电话", wcf_center));
                        sheet.addCell(new Label(4, 0, "Email", wcf_center));
                        for (int i = 0; i < list.size(); i++) {
                           Customer customer = list.get(i);
                            String sexStr = "";
                            if(null!=customer){
                                if(customer.getSex()==0){
                                    sexStr = "男";
                                }else if(customer.getSex()==1){
                                    sexStr = "女";
                                }else if(customer.getSex()==2){
                                    sexStr = "未知";
                                }
                            }
                            sheet.addCell(new Label(0, i + 1, StringUtils.defaultString(customer.getName()), wcf_left));
                            sheet.addCell(new Label(1, i + 1,  sexStr , wcf_left));
                            sheet.addCell(new Label(2, i + 1,customer.getAge()==null?"":customer.getAge().toString(), wcf_left));
                            sheet.addCell(new Label(3, i + 1,customer.getPhone()==null?"":customer.getPhone().toString(), wcf_left));
                            sheet.addCell(new Label(4, i + 1,customer.getEmail()==null?"":customer.getEmail().toString(), wcf_left));
                        }
                    }
                }, response);
            } else {
                String js = "<script>alert('没有需要导出的内容');history.back();</script>";
                response.getWriter().print(js);
            }
        } catch (Exception e) {
            logger.error("异常", e);
        }
    }


}
