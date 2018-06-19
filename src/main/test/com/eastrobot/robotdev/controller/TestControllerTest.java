package eastrobot.robotdev.controller;

import com.alibaba.fastjson.JSONObject;
import eastrobot.robotdev.ControllerBaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * author: alan.peng
 * description:
 * date: create in 17:24 2018/6/19
 * modified By：
 */
public class TestControllerTest extends ControllerBaseTest{

    @Test
    public void test1(){
        try {
            String responseStr = mockMvc.perform(post("/test1.do").param("name","alan").param("age","11")).andDo(print())
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
            System.out.println(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 请求数据json格式
     */
    @Test
    public void test2(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","alan");
        jsonObject.put("age","18");
        try {
            String responseStr = mockMvc.perform(post("/test2.do").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString())).andDo(print())
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
            System.out.println(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
