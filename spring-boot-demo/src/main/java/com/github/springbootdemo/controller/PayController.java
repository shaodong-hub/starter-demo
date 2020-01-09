package com.github.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 上午9:30 2020/1/9
 * 项目名称 starter-demo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@RestController
public class PayController {

    @PostMapping("/pay")
    public String pay() {
        return getMessage();
    }

//    @PostMapping("/pay")
//    public String pay() {
//        long start = System.currentTimeMillis();
//        String message = getMessage();
//        long end = System.currentTimeMillis();
//        log.info("耗时：{}ms  请求的url： {}", (end - start), "/pay");
//        return message;
//    }

    private String getMessage(){
        return "pay success";
    }

}
