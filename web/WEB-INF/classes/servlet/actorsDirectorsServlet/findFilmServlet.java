package servlet.actorsDirectorsServlet;

import Entity.Film;
import Service.FilmService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by Lino on 06.05.2017.
 */
@WebServlet("/find-film")
public class findFilmServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/filmsJSP/find-film.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filmYear = req.getParameter("yearFilm");

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/filmsJSP/find-film.jsp");
        req.setAttribute("films",FilmService.getInstance().yearFilm(LocalDate.parse(filmYear)));
        requestDispatcher.forward(req, resp);
    }
}
