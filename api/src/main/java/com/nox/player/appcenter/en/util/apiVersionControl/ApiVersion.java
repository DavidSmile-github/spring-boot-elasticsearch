package com.nox.player.appcenter.en.util.apiVersionControl;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiVersion {
    /**
     * 版本号
     * @return version
     */
    double value();
}
