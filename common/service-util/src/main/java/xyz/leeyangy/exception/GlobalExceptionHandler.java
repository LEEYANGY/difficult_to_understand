package xyz.leeyangy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.leeyangy.common.result.R;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.fail();
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.fail().message("执行了特定异常处理");
    }

    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public R error(AuthException e){
        e.printStackTrace();
        return R.fail().message(e.getMessage()).code(e.getCode());
    }
}
