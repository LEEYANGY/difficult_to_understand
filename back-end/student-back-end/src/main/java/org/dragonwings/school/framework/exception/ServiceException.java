package org.dragonwings.school.framework.exception;


import lombok.Data;
import org.dragonwings.school.framework.exception.enums.abs.AbstractBaseExceptionEnum;

/**
 * @Package: com.lyy.security.framwork.exception
 * @Author: LEEYANGYANG
 * @Create: 2022/11/2 20:28
 * @Description:
 */
@Data
public class ServiceException extends RuntimeException{


    private Integer code;

    private String errorMessage;


    public ServiceException(Integer code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public ServiceException(AbstractBaseExceptionEnum exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }



}

