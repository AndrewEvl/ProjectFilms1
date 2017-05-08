package servlet.filmsServlet;

import Entity.Film;
import Entity.Review;
import Entity.User;
import Service.FilmService;
import Service.ReviewService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 11.04.2017.
 */
@WebServlet("/filmsinfo")
public class FilmsFullInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setAttribute("info", FilmService.getInstance().fullFilmInfo(Long.parseLong((req.getParameter("id")))).get());
       getServletContext().getRequestDispatcher("/WEB-INF/jsp/filmsJSP/film-full-info.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String review = req.getParameter("review");


        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/filmsJSP/film-full-info.jsp");
        requestDispatcher.forward(req, resp);
    }
}
