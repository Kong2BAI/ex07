package com.controller;

import com.entity.User;
import com.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ex07/getUser")
public class GetUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userid = Integer.parseInt(req.getParameter("userid"));
        User user = UserService.getUser(userid);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/WEB-INF/JSP/getUser.jsp").forward(req,resp);
    }
}
