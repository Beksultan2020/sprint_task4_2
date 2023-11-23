package Servlets;

import db.DBManager_Items;
import db.DBManager_Users;
import db.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/registerShop")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String full_name = req.getParameter("FullName");
        String password =req.getParameter("password");
        String passwordRep =req.getParameter("passwordRep");
        String email =req.getParameter("email");

        String redirect="/register?ERROR";

        User exists= DBManager_Items.getUser(email);
        if(exists==null){
            if(password.equals(passwordRep)){
                User user=new User();
                user.setEmail(email);
                user.setEmail(password);
                user.setEmail(full_name);
                DBManager_Users.addUser(user);
                resp.sendRedirect("/signInShop");
            }
            else {
                resp.sendRedirect(redirect);
            }
        }else {
            resp.sendRedirect(redirect);
        }
    }
}
