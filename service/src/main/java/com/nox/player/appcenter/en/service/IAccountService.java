package com.nox.player.appcenter.en.service;

import com.nox.player.appcenter.en.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户基础信息表
 服务类
 * </p>
 *
 * @author David
 * @since 2020-04-09
 */
public interface IAccountService extends IService<Account> {

    void saveTestToEs();
}
