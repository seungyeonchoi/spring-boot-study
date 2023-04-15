package hello.container;

import javax.servlet.ServletContext;

public interface AppInit {
    void onStartup(ServletContext servletContext);
}
