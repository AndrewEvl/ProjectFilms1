package servlet.actorsDirectorsServlet;

import Service.ActorDirectorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lino on 30.04.2017.
 */
@WebServlet("/fullinfoactor")
public class fullActorsInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("actor", ActorDirectorService.getInstance().actDirInfo(Long.parseLong((req.getParameter("id")))).get());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/actorDirJSP/actor-full-info.jsp").forward(req, resp);
    }
}
