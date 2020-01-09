package com.github.smsspringbootstarter.service;

import java.util.Set;

/**
 * <p>
 * 创建时间为 下午9:50 2020/1/8
 * 项目名称 starter-demo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISmsCaptchaDetailService {

    /**
     * 验证码有效期
     *
     * @return int
     */
    int getValidSecond();

    /**
     * 获取验证码的 URL
     *
     * @return String
     */
    String getSmsUrl();

    /**
     * 获取验证码的参数名称
     *
     * @return String
     */
    String getSmsParam();

    Set<String> getValidMethods();

    Set<String> getValidUrls();


}
