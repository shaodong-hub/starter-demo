package com.github.smsspringbootstarter.config;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

/**
 * <p>
 * 创建时间为 下午7:52 2020/1/8
 * 项目名称 starter-demo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "com.github.captcha")
public class ConfigSmsCaptchaProperty {

    /**
     * 验证码默认有效期
     */
    private Integer validSecond = 60;

    /**
     * 验证码默认获取路径
     */
    private String smsUrl = "/code/sms";

    /**
     * 获取验证码时，手机号码传递的字段
     */
    private String smsParam = "mobile";

    /**
     * 验证码校验的请求方式
     */
    private Set<String> validMethods = Sets.newHashSet("POST");

    /**
     * 验证码校验的请求路径
     */
    private Set<String> validUrls = Sets.newHashSet("/authentication/mobile");
}
