package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class OsEnv {

    public static void main(String[] args) {
        Map<String, String> envMap = System.getenv(); // 다른 프로그램에서도 사용할 수 있는 전역변수
        for (String key: envMap.keySet()) {
            log.info("env {}={}", key, envMap.get(key)); // 00:46:40.026 [main] INFO hello.external.OsEnv - env USER=user
        }

        // 개발환경: DBURL=dev.db.com
        // 운영환경: DBURL=prod.db.com
        System.getenv("DBURL");
    }
}
