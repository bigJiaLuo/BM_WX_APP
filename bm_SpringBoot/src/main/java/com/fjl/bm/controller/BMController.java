package com.fjl.bm.controller;


import com.fjl.bm.service.BMService;
import com.fjl.bm.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TOOD
 *
 * @author luo
 * @version 1.0
 * @date 2020/9/9 14:46
 */
@RestController
@RequestMapping("/bm")
public class BMController{
    @Autowired
    private BMService bmService;

    /**
     * 查看所有保姆，并返回json
     * @throws IOException
     * @return
     */
    @RequestMapping("/selectAll")
    public Map<String, Object> selectAll() throws IOException {

        Map<String, Object> stringObjectHashMap = new HashMap<String,Object>();
        List<Tb_bm> bms = bmService.select();
        for (Tb_bm bm : bms) {
            String[] split = bm.getBmimgs().split(",");
            bm.setBmimgss(split);
        }
        stringObjectHashMap.put("list",bms);
        return stringObjectHashMap;
       /* HttpSession session = request.getSession();
        session.setAttribute("bms",bms);
        response.sendRedirect("/BMProgram_war/list.jsp");*/
    }

    /**
     * 返回指定的保姆
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/selectOne")
    public Map<String,Object> selectOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        //获取bmid，返回tb_bm保姆对象的json格式
        String bmid = request.getParameter("bmid");
        Tb_bm tb_bm = bmService.selectOne(bmid);
        String[] split = tb_bm.getBmimgs().split(",");
        tb_bm.setBmimgss(split);
        stringObjectHashMap.put("bm",tb_bm);
        return stringObjectHashMap;
    }

    /**
     * 创建订单
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/createorder")
    public Object createorder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //jdbc
        ResultDto resultDto = new ResultDto();
        //获取表单数据
        request.setCharacterEncoding("utf-8");

        String bmid = request.getParameter("bmid");
        String username = new String(request.getParameter("username"));

        String salary = request.getParameter("salary");
        String startYear = request.getParameter("startYear");
        String startMonth = request.getParameter("startMonth");
        String startDay = request.getParameter("startDay");
        String endYear = request.getParameter("endYear");
        String endMonth = request.getParameter("endMonth");
        String endDay = request.getParameter("endDay");
        String mark = new String(request.getParameter("mark"));
        String oid = getOid();
        //如何计算月的数量
        int count = getMonths(startYear,startMonth,startDay,endYear,endMonth,endDay);
        BigDecimal amount = new BigDecimal(Double.parseDouble(salary)*count);
        boolean flag = bmService.createorder(oid,bmid,username,count,amount,mark);
        if (flag){
            resultDto.setMsg("预约成功！");
            resultDto.setResult(true);
        }else{
            resultDto.setResult(false);
            resultDto.setMsg("预约失败！");
        }
        return resultDto;
    }

    //获取月的数量
    private int getMonths(String startYear, String startMonth, String startDay, String endYear, String endMonth,
                          String endDay) {

        int count = 0;
        //把string=>int
        int sy = Integer.parseInt(startYear);
        int sm = Integer.parseInt(startMonth);
        int sd = Integer.parseInt(startDay);
        int ey = Integer.parseInt(endYear);
        int em = Integer.parseInt(endMonth);
        int ed = Integer.parseInt(endDay);

        if(ey-sy==0) {
            count = em-sm;
            if(ed-sd>0) {
                count+=1;
            }
        }else {
            count=(ey-sy)*12;
            count += em-sm;
            if(ed-sd>0) {
                count+=1;
            }
        }
        return count;
    }

    //生成订单id的规则
    private String getOid() {
        //要得到20190530102120001
        Date date = new Date();
        String pattern = "yyyyMMddHHssmmSSS";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String oid = sdf.format(date);
        return oid;
    }


    /**
     * 查询指定用户的所有保姆订单
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("orderlist")
    public Object orderlist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        List<Tb_bmOrder> bmListByname = bmService.findByUsername(username);
        return bmListByname;
    }
}
