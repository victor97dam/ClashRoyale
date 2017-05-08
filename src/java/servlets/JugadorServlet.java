/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Jugador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import royaleBeans.RoyaleEJB;
import Util.MD5;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author DAM
 */
@WebServlet(name = "JugadorServlet", urlPatterns = {"/JugadorServlet"})

public class JugadorServlet extends HttpServlet {

    @EJB
    RoyaleEJB RoyaleEJB;

    public static final String STATUS_OK = "Jugador Creado";
    public static final String STATUS_FAIL = "Error Jugador no Creado";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if ("Login".equals(request.getParameter("action"))) {
            String user = request.getParameter("usuario");
            String pwd = MD5.getMD5(request.getParameter("password"));
            if (RoyaleEJB.login(user, pwd)) {
                request.setAttribute("status", STATUS_OK);
                request.getSession(true).setAttribute("user", user);
                request.getRequestDispatcher("/Main.jsp").forward(request, response);
            } else {
                request.setAttribute("status", STATUS_FAIL);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else if ("Crear".equals(request.getParameter("action"))) {
            String usuario = request.getParameter("usuario");
            String password = MD5.getMD5(request.getParameter("password"));
            Jugador j = new Jugador(usuario, 1, 0, password);
            if (RoyaleEJB.insertarJugador(j)) {

                request.setAttribute("status", STATUS_OK);
            } else {
                request.setAttribute("status", STATUS_FAIL);
            }
            request.getRequestDispatcher("/Index.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
