package fun.chenqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Hello world!
 *
 */
@EnableZuulProxy // 开启Zuul服务网关的功能
@SpringBootApplication // 当前启动类是配置类
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}