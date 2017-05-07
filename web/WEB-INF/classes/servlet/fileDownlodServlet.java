package servlet;

import Service.FilmService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lino on 07.05.2017.
 */
@WebServlet("/getFile")
public class fileDownlodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-disposition", "attachment; filename=report.txt");
        resp.getWriter().write(String.valueOf(FilmService.getInstance().downlodFile()));
    }
}
