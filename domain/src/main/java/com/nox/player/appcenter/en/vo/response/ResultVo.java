package com.nox.player.appcenter.en.vo.response;

/**
 * @author 多点哈哥
 */
public class ResultVo<T> {

    // 错误编码.0的时候代表成功
    private Integer code;

    private String message="";

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
