package com.evivv.store.controller;

import com.evivv.store.service.ex.ProductNotFoundException;
import com.evivv.store.service.ex.ServiceException;
import com.evivv.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制层类的基类，主要做异常的处理
 */
public class BaseController {
    public static final  int OK = 200;

    // 请求处理方法,这个方法的返回值就是需要传递给前端的数据
    // 自动将异常对象传递给此方法的参数列表上
    // 当项目中产生了异常，被统一拦截到此方法中，这个方法此时就充当的是请求处理的方法，方法的返回值就直接给前端
    @ExceptionHandler(ServiceException.class) // 用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>();
        if (e instanceof ProductNotFoundException){
            result.setState(4000);
            result.setMessage("尝试访问的商品数据不存在");
        }
        return result;
    }

}
