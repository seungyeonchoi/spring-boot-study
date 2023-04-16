package hello.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration //@MySpringBootApplication로 바로 빈 등록시킬 것이므로 불필요
public class HelloConfig {

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }
}
