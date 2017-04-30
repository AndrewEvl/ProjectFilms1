package servlet.actorsDirectorsServlet;

import Service.ActorDirectorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lino on 29.04.2017.
 */
@WebServlet("/actordirectorinfo")
public class actorsDirectorsInfo extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("info", ActorDirectorService.getInstance().fullActorDirector());
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/actorDirJSP/actorDirectorInfo.jsp");
        requestDispatcher.forward(req,resp);
    }
}
