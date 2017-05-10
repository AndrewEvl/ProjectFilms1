package servlet.filmsServlet;

import Dao.FilmDao;
import Entity.ActorDirector;
import Entity.Film;
import Entity.Role;
import Service.ActorDirectorService;
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
 * Created by User on 19.04.2017.
 */
@WebServlet("/filmsave")
public class FilmSave extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/filmsJSP/filmSave.jsp");
        req.setAttribute("genres", FilmService.getInstance().fullGenres());
        req.setAttribute("role", ActorDirectorService.getInstance().allRole());
        req.setAttribute("roleOne", ActorDirectorService.getInstance().allRole());
        req.setAttribute("actDir", ActorDirectorService.getInstance().fullActorDirector());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        LocalDate releaseDay = LocalDate.parse(req.getParameter("releaseDay"));
        String country = req.getParameter("country");
        Long genreId = Long.valueOf(req.getParameter("genre"));

        Long role = Long.valueOf(req.getParameter("role"));
        Long firstId = Long.valueOf(req.getParameter("firstId"));

        Long roleOne = Long.valueOf(req.getParameter("roleOne"));
        Long secondId = Long.valueOf(req.getParameter("secondId"));

        Film film = new Film(name, releaseDay, country);
        FilmService.getInstance().addFilm(film, genreId, firstId, role);
        FilmDao.getInstance().addActor(new ActorDirector(secondId,new Role(roleOne)),film.getId());

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/filmsJSP/film-success.jsp");
        requestDispatcher.forward(req, resp);
    }
}
