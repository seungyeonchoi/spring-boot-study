package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class CommandLineV1 {

    public static void main(String[] args) {
        for(String arg: Arrays.asList(args)) {
            // program arguments: dataA dataB
                //00:59:16.404 [main] INFO hello.external.CommandLineV1 - arg=dataA
                //00:59:16.406 [main] INFO hello.external.CommandLineV1 - arg=dataB
            // program arguments: url=devdb username=dev_user password=dev_pw // 파싱되지않고 문자열 그대로 들어옴 -> key-value 쌍으로 쓰려면 개발자가 직접 파싱해야 함
                //01:00:31.008 [main] INFO hello.external.CommandLineV1 - arg=url=devdb
                //01:00:31.013 [main] INFO hello.external.CommandLineV1 - arg=username=dev_user
                //01:00:31.013 [main] INFO hello.external.CommandLineV1 - arg=password=dev_pw
            log.info("arg={}", arg);
        }
    }
}
