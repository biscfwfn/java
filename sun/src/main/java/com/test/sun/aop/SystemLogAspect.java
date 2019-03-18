package com.test.sun.aop;

import com.test.sun.ExceptionHandling.UserDefinedException;
import com.test.sun.service.TestService;
import org.apache.catalina.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 切点类 能拿到方法的参数信息
 */
@Aspect
@Component
public class SystemLogAspect {

    // 本地异常日志记录对象
    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    @Autowired
    private TestService testService;

    // Controller层切点,针对在业务模块标注SystemControllerLog注解记录日志
    @Pointcut("@annotation( com.test.sun.aop.SystemControllerLog )")
    public void controllerAspect() {
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) throws UserDefinedException {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            // 请求的IP
            String logIP = request.getHeader("X-Real-IP");
//       if (StringUtils.isEmpty(logIP)) {
//          logIP = request.getRemoteAddr();
//       }
            String userID = request.getParameter("UserID");
            String userName = request.getParameter("UserName");
//       if (StringUtils.isEmpty(userID) || StringUtils.isEmpty(userName)) {
//          logger.debug("操作日志-->日志添加:用户名或用户ID为空，返回不添加日志!");
//          return;
//       }

            SystemLogModel slm = getControllerMethodDescription(joinPoint);
            slm.setLogIP(logIP);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
            String date = dateFormat.format(new Date());
            slm.setTimeFlag(date);
            slm.setFlagID(userID);
            slm.setFlagName(userName);

            // *========控制台输出=========*//
            logger.debug("=====注解参数获取开始=====");
            logger.debug("请求方法:"
                    + (joinPoint.getTarget().getClass().getName() + "."
                    + joinPoint.getSignature().getName() + "()"));
            logger.debug("操作模块:" + slm.getModuleID());
            logger.debug("操作方法:" + slm.getLogAction());
            logger.debug("操作内容:" + slm.getLogContent());
            logger.debug("请求IP:" + slm.getLogIP());
            logger.debug("FlagID:" + slm.getFlagID());
            logger.debug("FlagName:" + slm.getFlagName());
            // *========数据库日志=========*//
//            int res = systemLogMapper.saveOrUpdate(slm);
//            if (res > 0) {
//                logger.info(">>>>>>>>保存日志成功");
//            }
            if(slm.getModuleID() != 12){
                throw new UserDefinedException("101","接口状态：关闭，不允许访问！");
            }
        } catch (UserDefinedException e) {
            // 记录本地异常日志
            logger.error("前置通知异常,保存日志异常信息:{}", e.getMessage());
            throw new UserDefinedException(e);
        } catch (Exception e) {
            throw new UserDefinedException("500",e.getMessage());
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static SystemLogModel getControllerMethodDescription(
            JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        SystemControllerLog log;
        SystemLogModel logM = new SystemLogModel();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    log = method.getAnnotation(SystemControllerLog.class);
                    logM.setModuleID(log.ModuleID());
                    logM.setLogAction(log.LogAction());
                    logM.setLogContent(log.LogContent());
                    break;
                }
            }
        }
        return logM;
    }
}