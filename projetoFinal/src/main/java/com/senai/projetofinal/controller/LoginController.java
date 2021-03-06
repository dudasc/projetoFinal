/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.controller;

import com.senai.projetofinal.dao.LoginInvalidoException;
import com.senai.projetofinal.dao.UsuarioDAO;
import com.senai.projetofinal.model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String action = req.getParameter("action");
        final String username = req.getParameter("login");
        final String password = req.getParameter("senha");

        try {
            
            Usuario usuario = usuarioDAO.login(username, password);

            req.getSession().setAttribute("usuario", usuario);

            //Cookie cookieUsuario = new Cookie("lembrarUsuario", username);
            //cookieUsuario.setHttpOnly(true);
            //cookieUsuario.setMaxAge(60 * 60 * 24 * 30);
            //resp.addCookie(cookieUsuario);

            resp.sendRedirect("./");
        } catch (LoginInvalidoException ex) {
            req.setAttribute("mensagem", ex.getMessage());
            req.getRequestDispatcher("login.html").forward(req, resp);
        }

    }

}
