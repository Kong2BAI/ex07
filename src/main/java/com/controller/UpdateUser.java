package com.controller;

import com.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ex07/updateUser")
public class UpdateUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("newName");
        int userid = Integer.parseInt(req.getParameter("userid"));
        UserService.updateUser(userid,name);
        resp.sendRedirect(req.getContextPath()+"/ex07/index");
    }
}
