package com.nox.player.appcenter.en.util.apiVersionControl;


import com.nox.player.appcenter.en.vo.response.ResultVo;

public class ApiUtil {

    public static ResultVo deprecatedService() {
        ResultVo vo = new ResultVo();
        vo.setCode(-2);
        return vo;
    }
}
