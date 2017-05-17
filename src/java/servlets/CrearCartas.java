/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Carta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import royaleBeans.RoyaleEJB;
import static servlets.JugadorServlet.STATUS_FAIL;
import static servlets.JugadorServlet.STATUS_OK;

/**
 *
 * @author DAM
 */
@WebServlet(name = "CrearCartas", urlPatterns = {"/CrearCartas"})
public class CrearCartas extends HttpServlet {

    @EJB
    RoyaleEJB dao;

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

        request.getRequestDispatcher("/CrearCartas.jsp").forward(request, response);

        String nombre = request.getParameter("nombre");
        String vida = request.getParameter("vida");
        String ataque = request.getParameter("ataque");
        String velocidad = request.getParameter("velocidad");
        String elixir = request.getParameter("elixir");
        String categoria = request.getParameter("categoria");
        Carta nuevacarta = new Carta(nombre, Integer.parseInt(vida), Integer.parseInt(ataque), Integer.parseInt(velocidad), Integer.parseInt(elixir), categoria);
        dao.insertarCarta(nuevacarta);
        if (dao.insertarCarta(nuevacarta)) {
            request.setAttribute("Message", "Carta Creada");
            request.getRequestDispatcher("/CrearCartas.jsp").forward(request, response);

        } else {
            request.setAttribute("Message", "Error Carta no creada");
            request.getRequestDispatcher("/CrearCartas.jsp").forward(request, response);

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
