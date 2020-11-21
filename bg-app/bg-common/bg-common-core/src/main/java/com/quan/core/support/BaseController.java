
package com.quan.core.support;

import com.quan.PublicUtil;
import com.quan.ThreadLocalMap;
import com.quan.base.cons.GlobalConstant;
import com.quan.base.dto.LoginAuthDto;
import com.quan.base.enums.ErrorCodeEnum;
import com.quan.base.exception.BusinessException;
import com.quan.wrapper.WrapMapper;
import com.quan.wrapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class Base controller.
 *
 * @author paascloud.net@gmail.com
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Gets login auth dto.
     *
     * @return the login auth dto
     */
    protected LoginAuthDto getLoginAuthDto() {
        LoginAuthDto loginAuthDto = (LoginAuthDto) ThreadLocalMap.get(GlobalConstant.Sys.TOKEN_AUTH_DTO);
        if (PublicUtil.isEmpty(loginAuthDto)) {
            throw new BusinessException(ErrorCodeEnum.UAC10011041);
        }
        return loginAuthDto;
    }

    /**
     * Handle result wrapper.
     *
     * @param <T>    the type parameter
     * @param result the result
     * @return the wrapper
     */
    protected <T> Wrapper<T> handleResult(T result) {
        boolean flag = isFlag(result);

        if (flag) {
            return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "操作成功", result);
        } else {
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "操作失败", result);
        }
    }

    /**
     * Handle result wrapper.
     *
     * @param <E>      the type parameter
     * @param result   the result
     * @param errorMsg the error msg
     * @return the wrapper
     */
    protected <E> Wrapper<E> handleResult(E result, String errorMsg) {
        boolean flag = isFlag(result);

        if (flag) {
            return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "操作成功", result);
        } else {
            return WrapMapper.wrap(Wrapper.ERROR_CODE, errorMsg, result);
        }
    }

    private boolean isFlag(Object result) {
        boolean flag;
        if (result instanceof Integer) {
            flag = (Integer) result > 0;
        } else if (result instanceof Boolean) {
            flag = (Boolean) result;
        } else {
            flag = PublicUtil.isNotEmpty(result);
        }
        return flag;
    }

//    protected long generateId() {
//        return UniqueIdGenerator.getInstance(IncrementIdGenerator.getServiceId()).nextId();
//    }

}
  