package com.test.sun.controller;

import com.test.sun.Utils.ResDataUtil;
import com.test.sun.Utils.RestUtil;
import com.test.sun.aop.SystemControllerLog;
import com.test.sun.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 测试接口
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @SystemControllerLog(LogAction = "查询", ModuleID = 11, LogContent = "测试aop示例2")
    @GetMapping()
    public Object GetTestList(){
        return new ResDataUtil(testService.GetTestList());
    }

    @SystemControllerLog(LogAction = "查询", ModuleID = 12, LogContent = "测试aop示例")
    @GetMapping("/dao")
    public Object TestDao(){
        return new ResDataUtil(testService.GetTestDao());
    }

    @GetMapping("/timeout")
    public Object sleep(){
        try {
            Thread.sleep(1000*3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "aaaa";
    }

    /**
     * 带参数接口
     */
    @GetMapping("/1")
    public Object t1(@RequestParam(value = "id" ,required = false) String id){
        return new ResDataUtil("参数：id=" + id);
    }

    /**
     * 测试RestTemplate
     */
    @GetMapping("rtg")
    public Object rtg(@RequestParam(value = "id",required = false) String id){
        String url = "http://127.0.0.1:8088/test/dao";
        if(null != id){
            url += ("?id=" + id);
        }
        RestUtil restUtil = new RestUtil();
        Map<String,Object> p = restUtil.GET(url);
        /*
        if(code != 0){
        throw new ;
        }
         */
        return new ResDataUtil(p.get("data"));
    }
}
