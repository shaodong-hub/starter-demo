package com.github.smsspringbootstarter.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 创建时间为 下午7:50 2020/1/8
 * 项目名称 starter-demo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Captcha implements Serializable {

    private static final long serialVersionUID = -2815701331592767971L;

    private String code;

    private LocalDateTime expireTime;

    public Captcha(String code, int validSecond) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(validSecond);
    }

    public boolean expired() {
        return LocalDateTime.now().isAfter(expireTime);
    }

}
