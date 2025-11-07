package com.michaelstucki;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // set Content-Type header, so browser knows it is sending text/html
        response.setContentType("text/html; charset=UTF-8");
        // servlet container sends response to browser
        response.getWriter().print(
                "<html>\n" +
                "<body>\n" +
                "<h1>Hello World</h1>\n" +
                "<p>This is my very first, embedded Tomcat, HTML page!</p>\n" +
                "</body>\n" +
                "</html>");
    }
}
