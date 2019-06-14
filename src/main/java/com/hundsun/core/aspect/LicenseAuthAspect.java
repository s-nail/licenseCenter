package com.hundsun.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;

import javax.annotation.PostConstruct;

/**
 * Created by jiayq24996 on 2019-06-05
 */
@Aspect
public class LicenseAuthAspect {
    Logger logger = LoggerFactory.getLogger(LicenseAuthAspect.class);
    //@Pointcut("execution(* com.hundsun.*.service.*.*(..))")
    //@Pointcut("execution(* com.hundsun.*.service.*.*(..)) && within(@com.hundsun.common.annotation.LicenseApi *)")

    public LicenseAuthAspect(){
        System.out.println("###################LicenseAuthAspect构造函数###################");
    }
    @PostConstruct
    private void init(){
        System.out.println("###################@PostConstruct###################");
    }

    /**
     * @within和@target针对类的注解,@annotation是针对方法的注解
     */
    @Pointcut(value = "@annotation(com.hundsun.common.annotation.LicenseApi)")
    //@Pointcut(value = "@within(com.hundsun.common.annotation.LicenseApi)")
    //@Pointcut(value = "target(com.hundsun.common.annotation.LicenseApi)")//@target启动失败，报空指针
    public void anyMethod() {
    }

    //@Before(value = "anyMethod()")
    public void before(JoinPoint joinPoint) {
        System.out.println("[Aspect] before advise");
        throw new IllegalArgumentException("第" + 1 + "个参数被注解NotNull.class修饰，,不能为Null");
    }

    @Around("anyMethod()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取请求报文头部元数据
        /*ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取请求对象
        HttpServletRequest request = requestAttributes.getRequest();
        //记录控制器执行前的时间毫秒数
        System.out.println("前置通知执行：");
        System.out.println("url:" + request.getRequestURL());
        System.out.println("method:" + request.getMethod());
        System.out.println("ip:" + request.getRemoteAddr());
        System.out.println("class_method:" + joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName());
        System.out.println("args:" + Arrays.toString(joinPoint.getArgs()));*/
        long begin = System.currentTimeMillis();
        String name = joinPoint.getSignature().getName();
        System.out.println("================路过Aspect===================");

        logger.info(joinPoint.getSignature().getDeclaringTypeName());
        logger.info(joinPoint.getSignature().getDeclaringType().getSimpleName());

        logger.error("License校验失败");
        Object[] sourceArgs = joinPoint.getArgs();
        sourceArgs[sourceArgs.length - 1] = new String("哈哈");
        Object obj = joinPoint.proceed(sourceArgs);

        System.out.println("方法：" + name + "执行结果：" + obj + "；耗时：" + (System.currentTimeMillis() - begin));

     /*   String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法的前置通知");

        //和controller层返回值类型不同时，会报类型不匹配异常
        *//*if(true){
            List<Integer> list = new ArrayList<>();
            return list;
        }*//*
         *//*if(true){
            throw new AccessDeniedException("您无权操作！");
        }*//*


        //读取注解
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ParamsCheck paramsCheck = method.getAnnotation(ParamsCheck.class);
        if (paramsCheck != null && paramsCheck.ignore()) {
            joinPoint.proceed();
        }*/
        return obj;
    }

}
