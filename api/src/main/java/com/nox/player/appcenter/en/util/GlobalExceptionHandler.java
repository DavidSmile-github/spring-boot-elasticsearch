package com.nox.player.appcenter.en.util;

import com.nox.player.appcenter.en.constant.ErrorConstant;
import com.nox.player.appcenter.en.exception.CustomException;
import com.nox.player.appcenter.en.vo.response.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value= CustomException.class)
    @ResponseBody
    public ResultVo customExceptionHandle(CustomException e){
        ResultVo vo = new ResultVo();
        vo.setCode(e.getCode());
        if(e.getMessage()!=null && e.isShow()) {
            vo.setMessage(e.getMessage());
        }
        if(!StringUtils.isEmpty(e.getData())){
            vo.setData(e.getData());
        }
        logger.warn("CUSTOMERROR:"+vo.getCode()+": show user the message - "+e.isShow()+":\n"+e.getMessage(),e);
        return vo;
    }

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public ResultVo exceptionHandle(Exception e){
        ResultVo vo = new ResultVo();
        vo.setCode(ErrorConstant.SERVER_ERROR.getCode());
        logger.error("SERVERERROR:"+ErrorConstant.SERVER_ERROR.getCode()+":"+e.getMessage(),e);
        return vo;
    }

   /* @ExceptionHandler(value=PassportException.class)
    @ResponseBody
    public ResultVo passportExceptionHandle(PassportException e){
        ResultVo vo = new ResultVo();
        vo.setCode(Integer.parseInt(e.getErrNo()));
        vo.setMessage(e.getErrMsg());
        logger.warn("PASSPORTERROR:" + vo.getCode() + ":" + e.getMessage(), e);
        return vo;
    }*/
}
