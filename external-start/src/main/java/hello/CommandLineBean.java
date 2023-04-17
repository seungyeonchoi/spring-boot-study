package hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CommandLineBean {

    private final ApplicationArguments arguments;

    public CommandLineBean(ApplicationArguments arguments) {
        this.arguments = arguments;
    }

    @PostConstruct
    public void init() {
        log.info("source {}", Arrays.stream(arguments.getSourceArgs()).collect(Collectors.toList())); // source [--url=devdb1, --url=devdb2, --username=dev_user, password=dev_pw]
        log.info("optionNames {}", arguments.getOptionNames()); // optionNames [url, username]
        Set<String> optionNames = arguments.getOptionNames();
        for(String optionName : optionNames) {
            // option args url=[devdb1, devdb2]
            // option args username=[dev_user]
            log.info("option args {}={}", optionName, arguments.getOptionValues(optionName));
        }
    }
}
