package com.melnychuk.spring.controllers;

import com.melnychuk.spring.AppContext;
import com.melnychuk.spring.services.NameProvider;
import org.springframework.context.ApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/name")
public class NameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var context = (ApplicationContext) req.getServletContext()
                .getAttribute(AppContext.SPRING_APP_CONTEXT.name());
        NameProvider provider = context.getBean(NameProvider.class);
        resp.getWriter().println(provider.getName());
    }
}

