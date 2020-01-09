package com.github.smsspringbootstarter.config;

import com.github.smsspringbootstarter.controller.SmsCodeLoginController;
import com.github.smsspringbootstarter.exception.handler.AuthFailureJsonHandlerImpl;
import com.github.smsspringbootstarter.filter.SecuritySmsValidationFilter;
import com.github.smsspringbootstarter.service.ISmsCaptchaDetailService;
import com.github.smsspringbootstarter.service.impl.SmsCaptchaDetailServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

/**
 * <p>
 * 创建时间为 下午11:29 2020/1/8
 * 项目名称 starter-demo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


public class SmsCaptchaAutoConfiguration {

    @Bean
    public ConfigSmsCaptchaProperty configSmsCaptchaProperty() {
        return new ConfigSmsCaptchaProperty();
    }

    @Bean
    @ConditionalOnMissingBean
    public ISmsCaptchaDetailService smsCaptchaDetailService() {
        return new SmsCaptchaDetailServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    @DependsOn(value = {"configSmsCaptchaProperty"})
    public SmsCodeLoginController smsCodeLoginController() {
        return new SmsCodeLoginController();
    }

    @Bean
    @ConditionalOnMissingBean
    public SecuritySmsValidationFilter securitySmsValidationFilter() {
        return new SecuritySmsValidationFilter();
    }

    @Bean
    @ConditionalOnMissingBean
    public IAuthFailureHandler authFailHandler() {
        return new AuthFailureJsonHandlerImpl();
    }

}
