package com.github.springbootdemo.runner;

import com.github.smsspringbootstarter.config.ConfigSmsCaptchaProperty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 创建时间为 上午1:14 2020/1/9
 * 项目名称 starter-demo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class Runner implements CommandLineRunner {

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        Map<String, ConfigSmsCaptchaProperty> map = applicationContext.getBeansOfType(ConfigSmsCaptchaProperty.class);
        map.forEach((k,v)->System.out.println(k));

        ConfigSmsCaptchaProperty captchaProperty = applicationContext.getBean(ConfigSmsCaptchaProperty.class);

        System.out.println(captchaProperty.toString());

    }
}
