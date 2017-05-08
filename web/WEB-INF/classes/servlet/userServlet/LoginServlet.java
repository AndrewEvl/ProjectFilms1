package servlet.userServlet;

import Entity.User;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lino on 02.05.2017.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nickName = req.getParameter("username");
        String password = req.getParameter("password");

        if (nickName.isEmpty() || password.isEmpty()) {
            doGet(req, resp);
            return;}
//        } else (nickName.equals() || password.equals());
        UserService.getInstance().loginUser(new User(password, nickName));
        //if ()
        req.getSession().setAttribute("userLoggedIn", true);
        resp.sendRedirect("/");
    }
}
