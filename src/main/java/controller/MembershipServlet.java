/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.RankDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import model.Rank;
import model.User;

/**
 *
 * @author locsu
 */
public class MembershipServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MembershipServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MembershipServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.sendRedirect(request.getContextPath() + "/membership.jsp");
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
    // lấy dữ liệu hiện tại của user (id) để thay đổi rank type
    HttpSession session = request.getSession();
    User currentUser = (User) session.getAttribute("user");

    // kiểm trả sự lựa chọn rank type của người dùng
    String membershipType = request.getParameter("membership");

    RankDAO rankDAO = new RankDAO();
    Rank u_rank = new Rank();

    try {
        if ("vip".equals(membershipType)) {
            // Handle premium membership
            u_rank.setId(currentUser.getId());
            u_rank.setType("Vip");
            rankDAO.updateRank(u_rank);
            request.setAttribute("msgVip", "Congratulations, you are now a VIP user");
            request.setAttribute("msgVipPlus", "");
        } else if ("vip++".equals(membershipType)) {
            // Handle premium++ membership
            u_rank.setId(currentUser.getId());
            u_rank.setType("Vip++");
            rankDAO.updateRank(u_rank);
            request.setAttribute("msgVipPlus", "Congratulations, you are now a VIP++ user");
            request.setAttribute("msgVip", "");
        }
        request.getRequestDispatcher("membership.jsp").forward(request, response);

    } catch (SQLException ex) {
        request.setAttribute("msg", "Error when getting membership!");
        request.getRequestDispatcher("membership.jsp").forward(request, response);
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
