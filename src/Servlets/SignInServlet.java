package Servlets;

import db.DBManager_Items;
import db.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/signInShop")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect="/signIN?ERROR";
        String email=req.getParameter("email");
        String password =req.getParameter("password");

        User user = DBManager_Items.getUser(email);
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        if(user != null && user.getEmail().equals(email) && user.getPassword().equals(password)){
            redirect="/userProfil";
        }
        resp.sendRedirect(redirect);
    }
}
