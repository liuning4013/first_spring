package com.test.first.aopentitiy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
/*import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;*/

/**
 * Created by liuning on 2017/9/18.
 */
@Component
@Aspect
/*
 * 定义切面执行的优先级，数字越低，优先级越高
 * 4.0后只有在切面中有这个属性
 */
@Order(-5)
public class CityAop {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(CityAop.class);

    @Pointcut("execution(* com.test.first.controller..*.*(..))")
    public void executeService(){}

    @Before("executeService()")
    public void doBefore(JoinPoint joinPoint) {
        //time.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) attributes.getRequest();
        //记录请求的内容
        logger.info("曹帅准备回家了！");
        logger.info("Request URL: " + request.getRequestURL().toString());
        logger.info("Request Method: " + request.getMethod());
       // String ip = request.getRemoteAddr();
       /* if (ip.indexOf(":0") > -1) {
            ip = IPUtil.getRealIp();
        }
        logger.info("IP: " + ip);*/
        logger.info("User-Agent: " + request.getHeader("User-Agent"));
        logger.info("Class Method: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("Cookies: " + request.getCookies());
        logger.info("Params: " + Arrays.toString(joinPoint.getArgs()));
        Enumeration<String> enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paraName = enums.nextElement();
            logger.info(paraName + ":" + request.getParameter(paraName));
        }
    }
    @AfterReturning("executeService()")
    public void doAfterReturning(JoinPoint joinPoint) {
       // logger.info("耗时 : " + ((System.currentTimeMillis() - time.get())) + "ms");
        logger.info("AppLogAspect.doAfterReturning()");
        logger.info("曹帅到家了！");
    }

/*//前置通知
    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        System.out.println("曹帅准备回家！");
        *//*获得目标方法的参数信息*//*
        Object[] obj = joinPoint.getArgs();
        //System.out.println("目标方法的参数信息"+obj[0]);
        *//*aop代理类的信息*//*
        joinPoint.getThis();
        *//*代理的目标对象*//*
        joinPoint.getTarget();
        //用的最多， 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        System.out.println(signature.getName());
        //aop代理类的名字
        System.out.println(signature.getDeclaringTypeName());
        //aop代理类信息
        signature.getDeclaringType();
        //获取requestattributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //获取requestattributes中获取httpservletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //获取session信息
        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Enumeration<String> enumeration = request.getParameterNames();
        *//*Map<String,String> parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }
        String str = JSON.toJSONString(parameterMap);
        if(obj.length > 0) {
            System.out.println("请求的参数信息为："+str);
        }*//*

    }

    //后置返回通知
    @AfterReturning(value = "execution(* com.test.first.controller..*.*(..))",returning="keys")
    public void doAfterreturnAdvice1(JoinPoint joinPoint,Object keys){
        System.out.println("第一个后置返回通知的返回值"+keys);
    }

  *//*  @AfterReturning(value = "execution(* com.test.first.controller..*.*(..))",returning="keys",argNames = "keys")
    public void doAfterreturnAdvice2(String keys){
        System.out.println("第二个后置通知的返回值"+keys);
    }*//*

    //后置异常通知
    @AfterThrowing(value = "executeService()",throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint,Throwable exception){
        //目标方法名：
        System.out.println(joinPoint.getSignature().getName());
        if(exception instanceof NullPointerException){
            System.out.println("发生了空指针异常!!!!!");
        }
    }

    //后置最终通知
    @After("executeService()")
    public void doAfterAdvice(JoinPoint joinPoint){

        System.out.println("后置通知执行了!!!!");
    }*/

    //环绕通知
 /*   @Around("executionexecution(* com.test.first.controller..*.*(..))")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("环绕通知的目标方法名："+proceedingJoinPoint.getSignature().getName());
        try {
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }*/
}
