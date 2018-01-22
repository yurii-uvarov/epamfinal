package main.java;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/name"})
public class ServletPart3 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = String.valueOf(request.getParameter("name"));
        ArrayList<String> list = (ArrayList<String>) session.getAttribute("names");
        if (list == null) {
            list = new ArrayList<String>();
        }
        list.add(name);
        session.setAttribute("names", list);
        response.sendRedirect("/part3.jsp");
    }
}

