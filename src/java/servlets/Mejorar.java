/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Baraja;
import entities.Carta;
import entities.Jugador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.mapping;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import royaleBeans.RoyaleEJB;

/**
 *
 * @author DAM
 */
@WebServlet(name = "Mejorar", urlPatterns = {"/Mejorar"})
public class Mejorar extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String Nombreusuario = (String) request.getSession(true).getAttribute("user");
        List<Jugador> j = new ArrayList<Jugador>();
        j = dao.InfoJugador(Nombreusuario);
        List<Baraja> cartasbyplayer = new ArrayList<>();
        cartasbyplayer = dao.Cartas(Nombreusuario);
        request.setAttribute("Jugador", j);
        request.setAttribute("cartasbyplayer", cartasbyplayer);
        request.getRequestDispatcher("/Mejorar.jsp").forward(request, response);
        String Cartamejorar = request.getParameter("cartaamejorar");
        if (dao.mejorarCarta(Cartamejorar, Nombreusuario, cartasbyplayer)) {
            cartasbyplayer = dao.Cartas(Nombreusuario);
            request.setAttribute("cartasbyplayer", cartasbyplayer);
            request.getRequestDispatcher("/Mejorar.jsp").forward(request, response);
        } else {
            cartasbyplayer = dao.Cartas(Nombreusuario);
            request.setAttribute("cartasbyplayer", cartasbyplayer);
            request.setAttribute("MejoraFail", "No se ha podido mejorar");
            request.getRequestDispatcher("/Mejorar.jsp").forward(request, response);
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
