/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Torcedor;

/**
 *
 * @author aluno
 */
@WebServlet(name = "ControlaTime", urlPatterns = {"/ControlaTime"})
public class ControlaTime extends HttpServlet {

    public void buscaTime(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Torcedor torcedor = new Torcedor();
            RequestDispatcher rd = null;
            List lista = new ArrayList();
            lista = torcedor.listaTimesPorTorcedor();
            Iterator it = lista.iterator();
            out.println("<h1>Vizualiza Time</h1>");
            out.println("<br/>");
            
            out.print("Bem Vindo: " + request.getAttribute("nomeR"));
            out.println("<br/>");
            out.print("Seu time: " + request.getAttribute("timeR"));
            out.println("<br/>");
            out.println("<br/>");
            out.println("<h2>Lista de Torcedores por time!</h2");
            
            out.println("<br/>");
            while (it.hasNext()) {
                out.println(it.next());
                out.println("<br/>");
            }

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
        try {
            buscaTime(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControlaTime.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlaTime.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            buscaTime(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControlaTime.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlaTime.class.getName()).log(Level.SEVERE, null, ex);
        }
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
