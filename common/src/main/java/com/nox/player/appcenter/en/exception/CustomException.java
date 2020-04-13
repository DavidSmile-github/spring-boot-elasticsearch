package com.nox.player.appcenter.en.exception;

import com.nox.player.appcenter.en.constant.ErrorConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public class CustomException extends Exception {
    private Logger logger = LoggerFactory.getLogger(CustomException.class);
    private static final long serialVersionUID = 4549161463974673813L;

    private Integer code;
    private String message;
    private boolean isShow=false;
    private Object data;

    public CustomException(Integer code , String message){
        super(code+":"+message);
        this.code=code;
        this.message=message;
    }

    public CustomException(Integer code , String message, boolean isShow){
        super(code+":"+message);
        this.code=code;
        this.message=message;
        this.isShow=isShow;
    }

    public CustomException(Integer code , String message, Object data, boolean isShow){
        super(code+":"+message);
        this.code=code;
        this.message=message;
        this.isShow=isShow;
        this.data=data;
    }

    public CustomException(ErrorConstant errorConstant){
        this(errorConstant.getCode(),errorConstant.getMessage());
    }

    public CustomException(ErrorConstant errorConstant, boolean isShow){
        this(errorConstant.getCode(),errorConstant.getMessage(),isShow);
    }

    /*public RelaxException(MisErrorConstant errorConstant, boolean isShow){
        this(errorConstant.getCode(),errorConstant.getMsg(),isShow);
    }*/

    public CustomException(ErrorConstant errorConstant, String otherMessage, boolean isShow){
        this(errorConstant.getCode(),otherMessage,isShow);
        logger.debug(errorConstant.getCode()+"|"
                +errorConstant.getMessage()+"|"
                +otherMessage+"|"
                +isShow);
    }

    public CustomException(ErrorConstant errorConstant, String... values){
        this(errorConstant.getCode(),MessageFormat.format(errorConstant.getMessage(),values),true);
    }
/*
    public RelaxException(MisErrorConstant errorConstant){
        this(errorConstant.getCode(),errorConstant.getMsg());
    }*/

    public CustomException(Integer code){
        super(code+"");
        this.code=code;
    }


    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public boolean isShow() {
        return isShow;
    }

    @Override
    public Throwable fillInStackTrace(){
        return this;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
