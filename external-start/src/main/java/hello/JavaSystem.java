package hello;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class JavaSystem {

    public static void print() {
        Properties properties = System.getProperties();
        for(Object key: properties.keySet()) {
            log.info("prop {}={}", key, properties.getProperty(String.valueOf(key))); // 00:50:28.477 [main] INFO hello.external.JavaSystemProperties - prop file.encoding=UTF-8
        }

        String url = System.getProperty("url");
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        // jvm 옵션을 -Durl=devdb -Dusername=dev_user -Dpassword=dev_pw << 이렇게 주고 실행
        log.info("url = {}", url);
        log.info("username = {}", username);
        log.info("password = {}", password);
    }
}
