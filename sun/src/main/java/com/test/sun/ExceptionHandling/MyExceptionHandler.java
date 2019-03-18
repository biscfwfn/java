package com.test.sun.ExceptionHandling;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理类
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Magical Sam");
    }

    @ResponseBody
    @ExceptionHandler(UserDefinedException.class)
    public Map<String,Object> handleException(UserDefinedException e){
        Map<String,Object> map = new HashMap<>();
        map.put("code",e.getCode());
        map.put("message",e.getMessage());
        return map;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String,Object> systemException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","-1");
        map.put("message",e.getMessage());
        return map;
    }
}
