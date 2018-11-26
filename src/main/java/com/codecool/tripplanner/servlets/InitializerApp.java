package com.codecool.tripplanner.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializerApp implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.addServlet("theServlet", new TestingPage());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
