package com.lee.aspect;

import com.lee.res.JsonRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public Object handle(Exception e, HttpServletRequest request, HttpServletResponse response) {
        logger.error("exception:{}", e);
        if (e instanceof MethodArgumentNotValidException) {
            //参数验证异常
            MethodArgumentNotValidException manve = (MethodArgumentNotValidException) e;
            BindingResult bindingResult = manve.getBindingResult();
            ObjectError objectError = bindingResult.getAllErrors().get(0);
            String message = objectError.getDefaultMessage();
            return new JsonRes<>(-1, message, "");
        }
        return new JsonRes<>(-1, e.getMessage(), "");
    }
}