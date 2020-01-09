package com.github.smsspringbootstarter.pojo;

/**
 * <p>
 * 创建时间为 下午8:01 2020/1/8
 * 项目名称 starter-demo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class CaptchaSms extends Captcha {

    private static final long serialVersionUID = -286563647016831215L;

    public CaptchaSms(String code, int validSecond) {
        super(code, validSecond);
    }

}
