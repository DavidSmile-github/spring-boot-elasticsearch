package com.nox.player.appcenter.en.util;


import com.nox.player.appcenter.en.constant.ErrorConstant;
import com.nox.player.appcenter.en.vo.response.ResultVo;

public class ControllerUtil {

    /**
     * controller层返回封装，直接返回成功
     */
    public static <T> ResultVo<T> returnSuccess(String message, T object) {
        return returnErrorWithCode(ErrorConstant.SUCCESS.getCode(), message, object);
    }

    public static <T> ResultVo<T> returnSuccess(T object) {

        return returnErrorWithCode(ErrorConstant.SUCCESS.getCode(), "", object);
    }

    public static <T> ResultVo<T> returnSuccess() {

        return returnErrorWithCode(ErrorConstant.SUCCESS.getCode(), "", null);
    }

    /**
     * controller层返回封装，根据具体的状态码返回
     */
    public static <T> ResultVo<T> returnErrorWithCode(Integer code, String message, T object) {
        ResultVo<T> vo = new ResultVo<>();
        vo.setCode(code);
        vo.setMessage(message);
        vo.setData(object);
        return vo;
    }


}
