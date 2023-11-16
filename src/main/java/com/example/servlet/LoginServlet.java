package com.example.servlet;

import com.example.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if( session.getAttribute("user") == null){
            resp.sendRedirect("/login.jsp");

        }
        else {
            resp.sendRedirect("/user/hello.jsp");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();


            try {
                if(Users.getInstance().getUsers().contains(req.getParameter("login"))){
                if(req.getParameter("password") !=null){
                    session.setAttribute("user", Users.getInstance().getUsers().contains("login"));
                    resp.sendRedirect("/user/hello.jsp");
                }
                RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
                dispatcher.forward(req,resp);

            }

            } catch (NullPointerException e){
                RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
                dispatcher.forward(req,resp);
    }
    }
}
