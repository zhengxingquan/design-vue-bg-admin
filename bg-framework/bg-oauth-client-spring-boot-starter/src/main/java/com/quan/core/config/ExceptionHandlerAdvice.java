package com.quan.core.config;

import com.quan.core.constant.exception.controller.ControllerException;
import com.quan.core.constant.exception.dao.DataAccessException;
import com.quan.core.constant.exception.hystrix.HystrixException;
import com.quan.core.constant.exception.service.ServiceException;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.constant.web.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

/***
 *  异常通用处理 服务于 oauth 服务端于客户端
 * @author zxq(956607644 @ qq.com)
 * @date 2020/11/30 18:47
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * IllegalArgumentException异常处理返回json 状态码:400
     *
     * @param e
     * @return
     */
    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result badRequestException(IllegalArgumentException e) {
        return JsonResult.failed(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }


    /**
     * AccessDeniedException异常处理返回json 状态码:403
     *
     * @param e
     * @return
     */
    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Result badMethodExpressException(AccessDeniedException e) {
        return JsonResult.failed(HttpStatus.FORBIDDEN.value(), e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleError(MissingServletRequestParameterException e) {
        return JsonResult.failed(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleError(MethodArgumentTypeMismatchException e) {
        return JsonResult.failed(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleError(MethodArgumentNotValidException e) {
        return JsonResult.failed(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleError(BindException e) {
        return JsonResult.failed(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleError(ConstraintViolationException e) {
        return JsonResult.failed(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleError(NoHandlerFoundException e) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleError(HttpMessageNotReadableException e) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Result handleError(HttpRequestMethodNotSupportedException e) {
        return JsonResult.failed(HttpStatus.METHOD_NOT_ALLOWED.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result handleError(HttpMediaTypeNotSupportedException e) {
        return JsonResult.failed(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), e.getMessage());
    }


    @ExceptionHandler({DataAccessException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result dataAccessException(DataAccessException e) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler({ServiceException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result serviceException(ServiceException e) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler({ControllerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result controllerException(ControllerException e) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler({HystrixException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result hytrixException(HystrixException e) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleError(Throwable e) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
