package com.nox.player.appcenter.en.repository.es;

import com.nox.player.appcenter.en.es.EsTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.ElasticsearchPersistentEntity;
import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchPersistentEntity;
import org.springframework.data.elasticsearch.repository.support.AbstractElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformation;
import org.springframework.data.elasticsearch.repository.support.MappingElasticsearchEntityInformation;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.data.util.TypeInformation;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

/**
 * @version 1.0
 * @author: HongBo﹒Liu
 * @date: 2020/4/10 12:06
 */
@Repository("testRepository")
public class TestElasticeSearchRepository extends AbstractElasticsearchRepository<EsTest, String> {

    /**
     *     当AbstractElasticsearchRepository提供的方法不足以完成全部功能时，即可通过该对象自定义
     * 操作行为。
     */
    private ElasticsearchOperations elasticsearchOperations;
    /**
     * 注入ElasticsearchOperations，并实例化BookElasticsearchRepository
     * 这里注入ElasticsearchOperations对象就是在application.yml中配置的参数自动装载的对象
     *
     */
    @Autowired
    public TestElasticeSearchRepository(ElasticsearchOperations elasticsearchOperations){
        super(createElasticsearchEntityInformation(), elasticsearchOperations);
        this.elasticsearchOperations = elasticsearchOperations;
    }
    /**
     * 创建ElasticsearchEntityInformation对象，该对象实现对索引对象相关信息的读取
     */
    private static ElasticsearchEntityInformation<EsTest, String> createElasticsearchEntityInformation() {
        TypeInformation<EsTest> typeInformation = ClassTypeInformation.from(EsTest.class);

        ElasticsearchPersistentEntity<EsTest> entity = new SimpleElasticsearchPersistentEntity<EsTest>(typeInformation);

        return new MappingElasticsearchEntityInformation<>(entity);
    }

    @Override
    protected String stringIdRepresentation(String aLong) {
        return aLong;
    }
}
