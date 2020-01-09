package com.github.smsspringbootstarter.controller;

import com.github.smsspringbootstarter.config.ConfigSmsCaptchaProperty;
import com.github.smsspringbootstarter.pojo.CaptchaSms;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.github.smsspringbootstarter.common.SecurityConstant.SESSION_KEY_CODE_SMS;

/**
 * <p>
 * 创建时间为 下午7:57 2020/1/8
 * 项目名称 starter-demo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@RestController
public class SmsCodeLoginController {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Resource
    private ConfigSmsCaptchaProperty property;

    @GetMapping("#{configSmsCaptchaProperty.smsUrl}")
    public void getSmsCode(HttpServletRequest request) throws ServletRequestBindingException {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        CaptchaSms smsCode = generate(servletWebRequest);
        sessionStrategy.setAttribute(servletWebRequest, SESSION_KEY_CODE_SMS, smsCode);
        String mobile = ServletRequestUtils.getRequiredStringParameter(request, property.getSmsParam());
        send(mobile, smsCode.getCode());
    }

    private CaptchaSms generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(6);
        return new CaptchaSms(code, property.getValidSecond());
    }

    private void send(String mobile, String code) {
        log.info("向手机发动验证码:{}-{}", mobile, code);
    }

}
