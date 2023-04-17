package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class CommandLineV2 {

    public static void main(String[] args) {
        for (String arg : Arrays.asList(args)) {
            // program arguments: --url=devdb1 --url=devdb2 --username=dev_user password=dev_pw // 파싱되지않고 문자열 그대로 들어옴 -> key-value 쌍으로 쓰려면 개발자가 직접 파싱해야 함
            //01:09:06.168 [main] INFO hello.external.CommandLineV2 - arg=--url=devdb1
            //01:09:06.171 [main] INFO hello.external.CommandLineV2 - arg=--url=devdb2
            //01:09:06.171 [main] INFO hello.external.CommandLineV2 - arg=--username=dev_user
            //01:09:06.171 [main] INFO hello.external.CommandLineV2 - arg=password=dev_pw
            log.info("arg={}", arg);
        }

        // program arguments: --url=devdb1 --url=devdb2 --username=dev_user password=dev_pw -> --를 붙이면 옵션인수라는 의미
        DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
        log.info("SourceArgs = {}", Arrays.stream(appArgs.getSourceArgs()).collect(Collectors.toList())); // SourceArgs = [--url=devdb, --username=dev_user, password=dev_pw]
        log.info("NonOptionArgs = {}", appArgs.getNonOptionArgs()); // NonOptionArgs = [password=dev_pw]
        log.info("OptionNames = {}", appArgs.getOptionNames()); // OptionNames = [url, username]

        Set<String> optionNames = appArgs.getOptionNames();
        for (String optionName : optionNames) {
            log.info("option arg {}={}", optionName, appArgs.getOptionValues(optionName));
        }

        List<String> url = appArgs.getOptionValues("url");
        List<String> username = appArgs.getOptionValues("username");
        List<String> password = appArgs.getOptionValues("password");

        log.info("url={}", url); // url=[devdb1, devdb2]
        log.info("username={}", username); // username=[dev_user]
        log.info("password={}", password); // password=null
    }
}
