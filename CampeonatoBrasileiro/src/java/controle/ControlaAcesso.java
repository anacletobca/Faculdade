package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Torcedor;

@WebServlet(urlPatterns = {"/ControlaAcesso"})
public class ControlaAcesso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void obterEmailTorcedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String email = request.getParameter("email1");
            RequestDispatcher rd = null;
            Torcedor torcedor = new Torcedor();
            Connection x = torcedor.getConexao();

            torcedor.setEmail(email);
            request.setAttribute("emailR", torcedor.getEmail());

            if (torcedor.obterTorcedorPorEmail()) {
                torcedor.obterTimePorEmail();                
                request.setAttribute("timeR", torcedor.getTime());
                request.setAttribute("nomeR", torcedor.getNome());
                //rd = request.getRequestDispatcher("/vizualizaTime.jsp");
                rd = request.getRequestDispatcher("/vizualizaTime.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Conta inválida");
                rd = request.getRequestDispatcher("/cadastraTorcedor.jsp");
                rd.forward(request, response);
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
            obterEmailTorcedor(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControlaAcesso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlaAcesso.class.getName()).log(Level.SEVERE, null, ex);
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
            obterEmailTorcedor(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControlaAcesso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlaAcesso.class.getName()).log(Level.SEVERE, null, ex);
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
