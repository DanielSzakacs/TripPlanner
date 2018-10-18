package com.codecool.tripplanner.servlets;

import com.codecool.tripplanner.JPA;
import com.codecool.tripplanner.config.TemplateEngineUtil;
import com.codecool.tripplanner.moduls.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.persistence.EntityManager;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "TestingPage", urlPatterns = {"/"})
@MultipartConfig
public class TestiPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JPA.getEntityManager();
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        EntityManager em = JPA.getEntityManager();
        List<WalkingTour> tours = em.createNamedQuery("displayalltour").getResultList();
        List<Timeslot> timeslots = em.createNamedQuery("getalltimeslot").getResultList();
        List<Movie> movies = em.createNamedQuery("getallmovies").getResultList();
        List<Location> locations = em.createNamedQuery("getalllocations").getResultList();
        List<Actor> actors = em.createNamedQuery("getallactors").getResultList();

        context.setVariable("tours",tours);
        context.setVariable("locations",locations);


       engine.process("agency/index.html", context, response.getWriter());

        em.clear();
        em.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        TemplateEngine engine = TemplateEngineUtil. getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());



        engine.process("agency/index.html", context, response.getWriter());
    }
}