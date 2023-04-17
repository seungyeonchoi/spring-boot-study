package hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class EnvironmentCheck {

    private final Environment env; // 커맨드 라인, 자바 시스템 속성 모두 동일하게 읽어올 수 있도록 추상화

    public EnvironmentCheck(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void init() {
        String url = env.getProperty("url");
        String username = env.getProperty("username");
        String password = env.getProperty("password");

        // program arguments: --url=devdb1 --url=devdb2 --username=dev_user password=dev_pw
        log.info("env url={}", url); // env url=devdb1,devdb2
        log.info("env username={}", username); // env username=dev_user
        log.info("env password={}", password); // env password=null

        // vm options: -Durl=devdb -Dusername=dev_user -Dpassword=dev_pw
        //url: devdb
        //username: dev_user
        //password: dev_pw

        /**
         * 커맨드 라인과 vm 옵션이 같은 key 를 동시에 정의하고 있으면?
         * -> 우선순위는 더 유연한 것이 높다!
         * -> 변경하기 어려운 파일보다 실행시 원하는 값을 줄 수 있는 바사 시스템 속성이 더 우선권을 가진다
         * -> 범위가 넓은 것보다 좁은 것이 우선권을 가진다
         *   - 자바 시스템 속성: 해당 jvm 안에서 모두 접근할 수 있음 (접근 범위 넓음)
         *   - 커맨드 라인ㅇ 옵션 인수: main의 args를 통해서 들어옴 (접근 범위 좁음)
         */
    }
}


