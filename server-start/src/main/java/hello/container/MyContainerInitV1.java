package hello.container;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

public class MyContainerInitV1 implements ServletContainerInitializer {
    // 서블릿 컨테이너에게 초기화 메서드는 이 클래스의 onStartUp임을 알려줘야함.
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("MyContainerInitV1.onStartup");
        System.out.println("c = " + c); // c = null
        System.out.println("ctx = " + ctx); // ctx = org.apache.catalina.core.ApplicationContextFacade@54fc0ffb
    }
}
