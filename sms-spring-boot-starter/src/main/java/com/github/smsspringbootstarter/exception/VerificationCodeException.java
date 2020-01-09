package com.github.smsspringbootstarter.exception;

/**
 * <p>
 * 创建时间为 下午8:45 2020/1/8
 * 项目名称 starter-demo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class VerificationCodeException extends AuthenticationException {

    private static final long serialVersionUID = -5415319408363885807L;

    public VerificationCodeException(String msg) {
        super(msg);
    }

    public VerificationCodeException(String msg, Throwable t) {
        super(msg, t);
    }

}
