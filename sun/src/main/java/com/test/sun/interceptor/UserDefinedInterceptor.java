package com.test.sun.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 拦截器 既能拿到http请求信息，也能拿到处理请求方法的信息，但是拿不到方法的参数信息。
 */
public class UserDefinedInterceptor implements HandlerInterceptor {

    /**
     * 预处理回调方法，实现处理器的预处理（如检查登陆），第三个参数为响应的处理器，自定义Controller
     * 返回值：true表示继续流程（如调用下一个拦截器或处理器）；false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
     */
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request,
                             javax.servlet.http.HttpServletResponse response,
                             java.lang.Object handler) throws java.lang.Exception {
        System.out.println("---------------------预处理----------------------------");
        String requestUri = request.getRequestURI();
        if(requestUri.startsWith(request.getContextPath())){
            requestUri = requestUri.substring(request.getContextPath().length(), requestUri.length());
        }
        if(requestUri.startsWith("/file")){
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("接口已关闭！");
            return false;
        }
        return true;
    }

    /**
     * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时我们可以通过modelAndView（模型和视图对象）对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
     */
    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest request,
                           javax.servlet.http.HttpServletResponse response,
                           java.lang.Object handler,
                           @org.springframework.lang.Nullable org.springframework.web.servlet.ModelAndView modelAndView) throws java.lang.Exception {
        System.out.println("--------------后处理---------------");
    }

    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，如性能监控中我们可以在此记录结束时间并输出消耗时间，还可以进行一些资源清理，类似于try-catch-finally中的finally，但仅调用处理器执行链中
     */
    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest request,
                                javax.servlet.http.HttpServletResponse response,
                                java.lang.Object handler, @org.springframework.lang.Nullable java.lang.Exception ex) throws java.lang.Exception {
        System.out.println("---------------请求处理完毕-------------------------0");
    }

}
