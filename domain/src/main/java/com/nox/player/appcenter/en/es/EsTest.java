package com.nox.player.appcenter.en.es;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @version 1.0
 * @author: HongBo﹒Liu
 * @date: 2020/4/10 11:50
 */
@Document(indexName = "appcenter_center_en", type = "test")
@Data
@ToString
public class EsTest {

    @Id
    private String id;

    private String testName;
}
