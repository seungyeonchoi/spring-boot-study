package hello.container;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@HandlesTypes(AppInit.class) // AppInit 인터페이스를 구현한 클래스들을 다 넘겨받음
public class MyContainerInitV2 implements ServletContainerInitializer {
    // 서블릿 컨테이너에게 초기화 메서드는 이 클래스의 onStartUp임을 알려줘야함.
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("MyContainerInitV2.onStartup");
        System.out.println("c = " + c); // c = [class hello.container.AppInitV1Servlet]
        System.out.println("ctx = " + ctx);

        for (Class<?> appInitClass : c) {
            try {
                // == new AppInitV1Servlet()
                AppInit appInit = (AppInit) appInitClass.getDeclaredConstructors()[0].newInstance();
                appInit.onStartup(ctx);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
