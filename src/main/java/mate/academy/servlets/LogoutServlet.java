package mate.academy.servlets;

import mate.academy.model.User;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/logout")
public class LogoutServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(LogoutServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        logger.debug(user.getInfo() + " logged out");
        request.getSession().invalidate();
        response.sendRedirect("/main");
    }
}
