package com.example.servlet;

import com.example.Users;
import sun.rmi.server.Dispatcher;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if( req.getAttribute("user") != null){
            resp.sendRedirect("/user/hello.jsp");
        }
        else {
            resp.sendRedirect("/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(Users.getInstance().getUsers().contains(req.getParameter("login"))){

            if(req.getParameter("password") !=null){
                req.setAttribute("user", Users.getInstance().getUsers().contains("login"));
                resp.sendRedirect("/user/hello.jsp");
            }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
        dispatcher.forward(req,resp);

    }
}
