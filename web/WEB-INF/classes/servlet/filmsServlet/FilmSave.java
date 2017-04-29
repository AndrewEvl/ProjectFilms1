package servlet.filmsServlet;

import Entity.ActorDirector;
import Entity.Film;
import Entity.Role;
import Service.ActorDirectorService;
import Service.FilmService;
import Service.UserService;

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
        req.setAttribute("actDir", ActorDirectorService.getInstance().fullActorDirector());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        LocalDate releaseDay = LocalDate.parse(req.getParameter("releaseDay"));
        String country = req.getParameter("country");
        Long genreId = Long.valueOf(req.getParameter("genre"));

        Long directorRole = Long.valueOf(req.getParameter("role"));
        Long actdirIdFirst = Long.valueOf(req.getParameter("firstId"));

        Long actorRole = Long.valueOf(req.getParameter("roleOne"));
        Long actdirIdSecond = Long.valueOf(req.getParameter("secondId"));

        String jspName = name.equals("") | country.equals("")
                 ? "filmSave.jsp" : "film-success.jsp";
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/filmsJSP/" + jspName);
        FilmService.getInstance().addFilm(new Film(name, releaseDay, country), genreId, actdirIdFirst, directorRole);
        FilmService.getInstance().addFilm(new Film(name, releaseDay, country), genreId, actdirIdSecond, actorRole);
        requestDispatcher.forward(req, resp);
        System.out.println(name);
        System.out.println(releaseDay);
        System.out.println(country);
        System.out.println(genreId);
        System.out.println(directorRole);
        System.out.println(actorRole);
        System.out.println(actdirIdFirst);
        System.out.println(actdirIdSecond);
    }
}
