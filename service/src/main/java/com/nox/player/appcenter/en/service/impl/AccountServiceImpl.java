package com.nox.player.appcenter.en.service.impl;

import com.nox.player.appcenter.en.entity.Account;
import com.nox.player.appcenter.en.es.EsTest;
import com.nox.player.appcenter.en.mapper.AccountMapper;
import com.nox.player.appcenter.en.repository.es.TestElasticeSearchRepository;
import com.nox.player.appcenter.en.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 * 用户基础信息表
 服务实现类
 * </p>
 *
 * @author David
 * @since 2020-04-09
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Autowired
    private TestElasticeSearchRepository testElasticeSearchRepository;
    @Override
    public void saveTestToEs() {
        EsTest test = new EsTest();
        test.setId("1");
        test.setTestName("david");
        log.info(testElasticeSearchRepository.existsById(test.getId()) + "");
        testElasticeSearchRepository.save(test);
        Optional<EsTest> testOptional = testElasticeSearchRepository.findById(test.getId());
        log.info(testOptional.get().toString());
    }
}
