package com.controller;

import com.entity.User;
import com.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.util.DataSourceUtil;
@WebServlet("/ex07/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var users = UserService.getUsers();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/WEB-INF/JSP/Index.jsp").forward(req,resp);
    }
}
