package com.nox.player.appcenter.en.controller;


import com.nox.player.appcenter.en.entity.Account;
import com.nox.player.appcenter.en.service.IAccountService;
import com.nox.player.appcenter.en.util.ControllerUtil;
import com.nox.player.appcenter.en.util.apiVersionControl.ApiVersion;
import com.nox.player.appcenter.en.vo.response.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户基础信息表
 前端控制器
 * </p>
 *
 * @author David
 * @since 2020-04-09
 */
@Controller
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("{id}")
    @ResponseBody
    public ResultVo<Account> find0(@PathVariable("id") Long id) {
        log.info(" account find by id {}" , id);
        Account account = accountService.getById(id);
        accountService.saveTestToEs();
        log.info("result {}", account);
        return ControllerUtil.returnSuccess(account);
    }
}
