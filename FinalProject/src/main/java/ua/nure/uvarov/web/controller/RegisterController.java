package ua.nure.uvarov.web.controller;

import ua.nure.uvarov.constants.Parameters;
import ua.nure.uvarov.entity.User;
import ua.nure.uvarov.services.RegisterService;
import ua.nure.uvarov.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register.do")
public class RegisterController extends HttpServlet {

    /**
     *
     */


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterService registrationService = (RegisterService) req.getServletContext().getAttribute(Parameters.REGISTER_SERVICE);
        registrationService.setBean(req);
        registrationService.setMap(req);
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterService registrationService = (RegisterService) req.getServletContext().getAttribute(Parameters.REGISTER_SERVICE);
        HttpSession session = req.getSession();
        UserService userService = (UserService) req.getServletContext().getAttribute(Parameters.USER_SERVICE);
        Map<String, String> errors = registrationService.getErrorMap(req,userService);
        if (errors.isEmpty()) {
            User user = registrationService.getUser(req);
            userService.create(user);
            session.setAttribute(Parameters.USER, user);
            resp.sendRedirect("index.jsp");
        } else {
            session.setAttribute(Parameters.S_BEAN, registrationService.getUserBean(req));
            session.setAttribute(Parameters.S_ERRORS, errors);
            resp.sendRedirect("register.do");
        }

    }


}