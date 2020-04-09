package com.parker.monitor.system.base;


import com.parker.monitor.system.api.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 控制器支持类
 * @author Parker
 */
@Slf4j
public abstract class BaseController {

    /**
     *统一异常处理
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Result exception(Exception e) {

        // 异常写入日志
        log.error(e.getMessage(),e);

        return Result.error(e.getMessage());
    }

}
