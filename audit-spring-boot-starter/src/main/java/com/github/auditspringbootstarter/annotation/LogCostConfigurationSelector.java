package com.github.auditspringbootstarter.annotation;

import com.github.auditspringbootstarter.config.InterceptorConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * 创建时间为 上午10:36 2020/1/9
 * 项目名称 starter-demo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class LogCostConfigurationSelector {

    @Bean
    @ConditionalOnMissingBean
    public InterceptorConfig interceptorConfig() {
        return new InterceptorConfig();
    }


}
