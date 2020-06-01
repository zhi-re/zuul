package fun.chenqi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenqi
 * @date 2019/7/9 14:21
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/zuul")
    public String s() {
        return "hello zuul";
    }
}
