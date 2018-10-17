package com.codecool.tripplanner.servlets;

import com.codecool.tripplanner.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.json.Json;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "TestingPage", urlPatterns = {"/"})
@MultipartConfig
public class TestiPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());


        String json = Json.createObjectBuilder()
                .add("key1", "value1")
                .add("key2", "value2")
                .build()
                .toString();

//        System.out.println(json);
//        OutputStream os = response.getOutputStream();
//        os.write(json.getBytes());
//        os.close();

//        engine.process("agency/index.html", context, response.getWriter());

        engine.process("agency/index.html", context, response.getWriter());

//        context.setVariable("user", json);
//        engine.process("myaccount.html", context, response.getWriter());
    }
}