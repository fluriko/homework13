package mate.academy.servlets;

import mate.academy.database.UserDao;
import mate.academy.database.impl.UserDaoHibImpl;
import mate.academy.model.User;
import mate.academy.service.validator.UserValidationService;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class LogServlet extends HttpServlet {
    private static final UserValidationService validationService = new UserValidationService();
    private static final UserDao userDao = new UserDaoHibImpl();
    private static final Logger logger = Logger.getLogger(LogServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("Guest started log in page");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login").trim();
        String password = request.getParameter("password").trim();
        String violations = validationService.validateDataForLogIn(login, password);
        if (violations.isEmpty()) {
            User user = userDao.getUserByLogin(login).get();
            user.setPasswordLength(6);
            request.getSession().setAttribute("user", user);
            logger.info(login + " logged in and started session");
            response.sendRedirect("/main");
        } else {
            request.setAttribute("violations", violations);
            doGet(request, response);
        }
    }
}
