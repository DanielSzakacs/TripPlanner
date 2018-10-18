package com.codecool.tripplanner.servlets;

import com.codecool.tripplanner.JPA;
import com.codecool.tripplanner.config.TemplateEngineUtil;
import com.codecool.tripplanner.searchHandler.NamedQueryHandler;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestingPage", urlPatterns = {"/"})
@MultipartConfig
public class TestiPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JPA.getEntityManager();
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
       engine.process("agency/index.html", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        TemplateEngine engine = TemplateEngineUtil. getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        NamedQueryHandler nqh  = new NamedQueryHandler();

        String city = request.getParameter("city");
        String genre = request.getParameter("genre");
        if(!city.equals("nothing")){
            System.out.println("CITY ======");
            context.setVariable("result", nqh.getAllWalkingTourByCityName(city));
        }
        if(!genre.equals("nothing")){
            System.out.println("======= genre");
            context.setVariable("result", nqh.getAllWalkingTourByGenre(genre));
        }else{
            response.sendRedirect("/");
        }
        engine.process("agency/index.html", context, response.getWriter());
    }
}