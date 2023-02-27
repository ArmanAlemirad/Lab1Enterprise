package com.example.lab1enterprise.servlet;

import com.example.lab1enterprise.entity.Persons;
import com.example.lab1enterprise.repository.PersonRepository;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonServlet", value = "/PersonServlet")
public class PersonServlet extends HttpServlet {

    @Inject
    PersonRepository repository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if( path == null || path.equals("/")) {
            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.println("<html><body>");

            out.println("<h1>" + "Persons" + "</h1>");
            out.println("<h1>" + path + "</h1>");
            for (Persons persons : repository.findAll())
                out.println("<div>" + persons.getId() + " : " + persons.getName() + " : " + persons.getPassword() + "</div>");
            out.println("</body></html>");
        }
    }
}
