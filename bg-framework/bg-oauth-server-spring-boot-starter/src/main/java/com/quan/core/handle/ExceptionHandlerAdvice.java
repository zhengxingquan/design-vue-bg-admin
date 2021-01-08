package com.quan.core.handle;

import com.quan.core.common.exception.controller.ControllerException;
import com.quan.core.common.exception.hystrix.HystrixException;
import com.quan.core.common.exception.service.ServiceException;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.Result;
import org.springframework.dao.DataAccessException;
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

/**
 * @author 作者 owen
 * @version 创建时间：2017年11月12日 上午22:57:51 异常通用处理
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * IllegalArgumentException异常处理返回json 状态码:400
     *
     * @param exception
     * @return
     */
    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result badRequestException(IllegalArgumentException exception) {
        return JsonResult.failed(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }


    /**
     * AccessDeniedException异常处理返回json 状态码:403
     *
     * @param exception
     * @return
     */
    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Result badMethodExpressException(AccessDeniedException exception) {
        return JsonResult.failed(HttpStatus.FORBIDDEN.value(), exception.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleError(MissingServletRequestParameterException exception) {
        return JsonResult.failed(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleError(MethodArgumentTypeMismatchException exception) {
        return JsonResult.failed(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleError(MethodArgumentNotValidException exception) {
        return JsonResult.failed(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleError(BindException exception) {
        return JsonResult.failed(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleError(ConstraintViolationException exception) {
        return JsonResult.failed(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleError(NoHandlerFoundException exception) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleError(HttpMessageNotReadableException exception) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Result handleError(HttpRequestMethodNotSupportedException exception) {
        return JsonResult.failed(HttpStatus.METHOD_NOT_ALLOWED.value(), exception.getMessage());
    }

    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result handleError(HttpMediaTypeNotSupportedException exception) {
        return JsonResult.failed(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), exception.getMessage());
    }


    @ExceptionHandler({DataAccessException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result dataAccessException(DataAccessException exception) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());

    }

    @ExceptionHandler({ServiceException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result serviceException(ServiceException exception) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }

    @ExceptionHandler({ControllerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result controllerException(ControllerException exception) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }

    @ExceptionHandler({HystrixException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result hytrixException(HystrixException exception) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleError(Throwable exception) {
        return JsonResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }
}
