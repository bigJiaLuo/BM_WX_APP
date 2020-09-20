package com.fjl.bm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 2020年2月10日13:03:25 洛 cn.jx
 * <p>
 * 对每一种不同类型的Servlet进行方法的分发
 * <p>
 * 进行方法分发的servlet必须继承此Servlet
 */
//@WebServlet("/user/*")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("baseServlet---service()");一个集合Servlet，用于 将 对同一张表操作的Servlet进行封装，减少Servlet类
//        Sys一个集合Servlet，用于 将 对同一张表操作的Servlet进行封装，减少Servlet类tem.out.println(this);
//        完成对代码的分发
//        1.获取 请求路径
        String requestURI = req.getRequestURI();
//        System.out.println(requestURI);

//        2.获取方法名称
        String methodName = requestURI.substring(requestURI.lastIndexOf("/") + 1);
//        System.out.println(methodName);

//        3.执行方法
//        3.1此方法是有子类Servlet调用，所以this就代表子类，methodName代表子类中的某个方法
        try {
//            3.2注意反射的使用， getMethod，只能获取 非private，protected修饰的方法
//            解决方法  1.将子类的方法修饰为public。2.使用暴力反射，忽略修饰符
//            Method method = this.getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
//            method.setAccessible(true);



//            推荐 去修改  方法修饰符,注意获取方法对象，需要传入 参数的 类字节码文件
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("this.getClass().getMethod(methodName);", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("method.invoke(this,req,resp);", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("method.invoke(this,req,resp);", e);
        }

    }

    /**
     * 将传入的对象 转为json返回
     * @param obj 入的对象
     * @return 转为json返回
     * @throws JsonProcessingException
     */
    public String writeValue(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * 将传入的对象，转为json，并写回且响应客户端
     * @param obj
     * @param response
     * @throws IOException
     */
    public void writeValue(Object obj, HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),obj);
    }


/*    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("baseServlet---doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }*/
}
