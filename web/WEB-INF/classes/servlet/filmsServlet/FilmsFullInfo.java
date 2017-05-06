package servlet.filmsServlet;

import Service.FilmService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 11.04.2017.
 */
@WebServlet("/films-info")
public class FilmsFullInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setAttribute("film", FilmService.getInstance().listFilms(Long.parseLong(req.getParameter("id"))).get());
       getServletContext().getRequestDispatcher("/WEB-INF/jsp/filmsJSP/film-full-info.jsp").forward(req, resp);
    }
}
