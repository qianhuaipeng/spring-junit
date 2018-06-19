package com.eastrobot.robotdev.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * author: alan.peng
 * description:
 * date: create in 17:19 2018/6/19
 * modified By：
 */
@Controller
public class TestController extends BaseController{


    @ResponseBody
    @RequestMapping("test1")
    public void test1(@RequestParam(required = false) String name, @RequestParam(required = false) String age, HttpServletResponse response){
        System.out.println("进来了");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("age",age);
        writeJson(response,jsonObject);
    }


    @ResponseBody
    @RequestMapping("test2")
    public void test2(HttpServletRequest request, HttpServletResponse response){
        System.out.println("进来了");
        System.out.println("-----"+getRequestBody(request));
        writeJson(response,getRequestBody(request));
    }


    /**
     *  获取请求body
     * @param req
     * @return
     */
    public static String getRequestBody(HttpServletRequest req) {
        String requestBody = "";
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            req.setCharacterEncoding("UTF-8");
            is = req.getInputStream();
            isr = new InputStreamReader(is, "UTF-8");
            br = new BufferedReader(isr);
            String line = "";
            StringBuffer buffer = new StringBuffer(1024);
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
            requestBody = buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                isr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return requestBody;
    }
}
