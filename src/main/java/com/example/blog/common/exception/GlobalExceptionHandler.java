package com.example.blog.common.exception;

import com.example.blog.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice // 异步捕获异常
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e){
        log.error("运行时异常: -----{}",e.toString());
        return Result.fail(e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public Result handler(ShiroException e){
        log.error("shiro认证或授权异常: -----{}",e.getMessage());
        log.error(e.toString());
        return Result.fail("401","未登录或登录过期,请重新登陆",null);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED) // test
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handler(MethodArgumentNotValidException e){
        log.error("数据参数不正确: -----{}",e.getMessage());

        ObjectError objectError = e.getBindingResult().getAllErrors().stream().findFirst().get();
        return Result.fail("401",objectError.getDefaultMessage(),null);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED) // test
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result handler(IllegalArgumentException e){
        log.error("assert参数不正确: -----{}",e.getMessage());
        return Result.fail("401",e.getMessage(),null);
    }
}
