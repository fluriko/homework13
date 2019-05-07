package mate.academy.servlets;

import mate.academy.database.GoodDao;
import mate.academy.model.Good;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/admin/editGood")
public class EditGoodServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(EditGoodServlet.class);
    private static final GoodDao GOOD_DAO = new GoodDao();
    private static Long goodId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Admin started edit good page");
        goodId = Long.parseLong(req.getParameter("id"));
        req.getRequestDispatcher("editGood.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Good good = GOOD_DAO.getGood(goodId).get();
        String newLabel = req.getParameter("label").trim();
        String newDescription = req.getParameter("description").trim();
        String newCategory = req.getParameter("category").trim();
        Double newPrice;
        try {
            newPrice = Double.parseDouble(req.getParameter("price"));
        } catch (Exception e) {
            newPrice = 0.0;
            logger.debug("Not correct data in field price", e);
        }
        String message = "successfully edited good " + goodId + ": " + good.getLabel();
        logger.debug("Admin tried to edit good " + goodId + ": " + good.getLabel());
        if (newLabel.length() < 3) {
            newLabel = good.getLabel();
        }
        if (newDescription.length() < 5) {
            newDescription = good.getDescription();
        }
        if (newCategory.length() < 3) {
            newCategory = good.getCategory();
        }
        if (newPrice <= good.getPrice() / 2) {
            newPrice = good.getPrice();
        }
        logger.info("Admin changed good " + goodId);
        GOOD_DAO.editGood(goodId, newLabel, newDescription, newCategory, newPrice);
        req.setAttribute("message", message);
        goodId = 0L;
        req.getRequestDispatcher("/admin/goods").forward(req, resp);
    }
}