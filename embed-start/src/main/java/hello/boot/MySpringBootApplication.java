package hello.boot;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ComponentScan //스캔대상을 지정하지 않으면, 이 패키지부터 이 하위 패키지들을 전부 스캔
public @interface MySpringBootApplication {
}
