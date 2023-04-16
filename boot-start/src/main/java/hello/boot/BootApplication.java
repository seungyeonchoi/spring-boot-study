package hello.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너를 생성한다
		// 2. WAS(내장 톰캣)을 생성한다
		SpringApplication.run(BootApplication.class, args);
	}

}
