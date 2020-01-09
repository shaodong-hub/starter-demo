package com.github.smsspringbootstarter.service.impl;

import com.github.smsspringbootstarter.config.ConfigSmsCaptchaProperty;
import com.github.smsspringbootstarter.service.ISmsCaptchaDetailService;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 下午9:53 2020/1/8
 * 项目名称 starter-demo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class SmsCaptchaDetailServiceImpl implements ISmsCaptchaDetailService {

    @Resource
    private ConfigSmsCaptchaProperty property;

    @Override
    public int getValidSecond() {
        return property.getValidSecond();
    }

    @Override
    public String getSmsUrl() {
        return property.getSmsUrl();
    }

    @Override
    public String getSmsParam() {
        return property.getSmsParam();
    }

    @Override
    public Set<String> getValidMethods() {
        return property.getValidMethods().stream().map(String::toUpperCase).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getValidUrls() {
        return property.getValidUrls();
    }
}
