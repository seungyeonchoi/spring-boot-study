package hello.container;

import hello.servlet.HelloServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class AppInitV1Servlet implements AppInit {

    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV1Servlet.onStartup");

        // 프로그래밍 방식으로 순수 서블릿 코드 등록
        ServletRegistration.Dynamic helloServlet = servletContext.addServlet("helloServlet", new HelloServlet()); // HelloServlet 객체가 컨테이너에 등록됨
        helloServlet.addMapping("/hello-servlet");
    }
}
