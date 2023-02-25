package org.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo")
public class ServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var writer = new PrintWriter(new BufferedOutputStream(resp.getOutputStream()));
        var response = "";
        var session = req.getSession();
        var sessionAttribute = session.getAttribute("name");
        var requestParameter = req.getParameter("name");
        if (requestParameter != null) {
            response = "PARAMETER:" + requestParameter;
            session.setAttribute("name", requestParameter);
        } else if (sessionAttribute != null) {
            response = "PARAMETER:" + sessionAttribute;
        } else {
            response = "NO_PARAMETER";
        }
        writer.println(response);
        writer.flush();
    }
}
