package com.michaelstucki;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class ApplicationLauncher {

    public static void main(String[] args) throws LifecycleException {

        // Create & configure Tomcat
        Tomcat tomcat = new Tomcat();
        tomcat.setport(8080);
        // Bootstrap Tomcat's HTTP engine
        tomcat.getConnector();

        // Only have one application and so do not want a context in our application, so use ""
        // docBase reference to static files is null since we have none
        Context ctx = tomcat.addContext("", null);
        // Add my Servlet to Tomcat
        Wrapper servlet = Tomcat.addServlet(ctx, "myFirstServlet", new MyFirstServlet());
        // To load and start my servlet immediately use 1
        servlet.setLoadOnStartup(1);
        // Servlet to reacte to any any incoming request
        servlet.addMapping("/*");

        // Start Tomcat
        tomcat.start();
    }
}
