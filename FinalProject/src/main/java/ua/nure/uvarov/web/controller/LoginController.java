package ua.nure.uvarov.web.controller;

import ua.nure.uvarov.constants.Messages;
import ua.nure.uvarov.constants.Parameters;
import ua.nure.uvarov.entity.User;
import ua.nure.uvarov.services.LoginService;
import ua.nure.uvarov.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        loginService = new LoginService();

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loginService.setMap(req);
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestHandler(req, resp);
    }

    private void requestHandler(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User user = loginService.getUser(req);
        UserService userService = (UserService) req.getServletContext().getAttribute(Parameters.USER_SERVICE);
        Map<String, String> errors = new HashMap<>();
        if (errors.isEmpty()) {
            User userResult = userService.tryToLogIn(user);
            if (userResult != null) {

                req.getSession().setAttribute(Parameters.S_USER, userResult);
               // req.setAttribute("s_user", userResult);
                resp.sendRedirect("main.do");
             //   req.getRequestDispatcher("/main.do").forward(req,resp);
            } else {
                if (user.isBlocked()) {
                    errors.put(Parameters.USER_ERR_MESSAGE, "U was blocked");
                }
                req.getSession().setAttribute(Parameters.S_ERRORS, errors);
                resp.sendRedirect("login.do");
            }
        } else {
            req.getSession().setAttribute(Parameters.S_ERRORS, errors);
            resp.sendRedirect("login.do");
        }
    }

}


