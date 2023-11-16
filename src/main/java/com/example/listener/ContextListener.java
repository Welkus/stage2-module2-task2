package com.example.listener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        sce.getServletContext().setAttribute("servletTimeInit",new Date().toString());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
