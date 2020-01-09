package com.github.smsspringbootstarter.filter;

import com.github.smsspringbootstarter.config.IAuthFailureHandler;
import com.github.smsspringbootstarter.exception.VerificationCodeException;
import com.github.smsspringbootstarter.pojo.CaptchaSms;
import com.github.smsspringbootstarter.service.ISmsCaptchaDetailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.github.smsspringbootstarter.common.SecurityConstant.SESSION_KEY_CODE_SMS;
import static com.github.smsspringbootstarter.common.SecurityConstant.SMS_CODE;

/**
 * <p>
 * 创建时间为 下午8:44 2020/1/8
 * 项目名称 starter-demo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
public class SecuritySmsValidationFilter extends OncePerRequestFilter {

    @Resource
    private IAuthFailureHandler handler;

    @Resource
    private ISmsCaptchaDetailService smsCaptchaDetailService;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.info("SecuritySmsValidationFilter");
        if (smsCaptchaDetailService.getValidUrls().contains(request.getRequestURI()) &&
                smsCaptchaDetailService.getValidMethods().contains(request.getMethod().toUpperCase())) {
            try {
                validate(new ServletWebRequest(request));
            } catch (VerificationCodeException exception) {
                handler.onAuthenticationFailure(request, response, exception);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void validate(ServletWebRequest servletWebRequest) throws VerificationCodeException, ServletRequestBindingException {
        CaptchaSms smsCode = (CaptchaSms) sessionStrategy.getAttribute(servletWebRequest, SESSION_KEY_CODE_SMS);
        String codeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(), SMS_CODE);
        if (StringUtils.isBlank(codeInRequest)) {
            throw new VerificationCodeException("验证码不能为空字符串!");
        }
        if (smsCode == null) {
            throw new VerificationCodeException("验证码不能为空!");
        }
        if (smsCode.expired()) {
            sessionStrategy.removeAttribute(servletWebRequest, SESSION_KEY_CODE_SMS);
            throw new VerificationCodeException("验证码过期!");
        }
        if (!StringUtils.equalsIgnoreCase(codeInRequest.trim(), smsCode.getCode())) {
            throw new VerificationCodeException("验证码不匹配!");
        }
        sessionStrategy.removeAttribute(servletWebRequest, SESSION_KEY_CODE_SMS);
    }
}
