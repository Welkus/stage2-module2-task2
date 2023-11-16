package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestListener;
import java.awt.event.ContainerListener;
import java.util.Date;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        sce.getServletContext().setAttribute("servletTimeInit",new Date());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    sce.getServletContext().removeAttribute("servletTimeInit");
    }
}
