package Control;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Nov 23, 2016
 */
@WebServlet(name="SessionDemoServlet", urlPatterns={"/SessionDemoServlet"})
public class SessionDemoServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Hvor kom vi fra?
        String origin = request.getParameter("origin");
        Enumeration<String> ps = request.getParameterNames();
        
        while (ps.hasMoreElements()) {
            System.out.println(ps.nextElement());
        }
        if(origin == null){
            System.out.println("noget gik galt og vi kom hertil uden en 'origin' parameter");
            return;
        }
        switch (origin) {
            case "cookiebased":
                HttpSession session = request.getSession();
                //String username = session.getAttribute("username").toString();
                response.sendRedirect("result.jsp");
                
                break;
            case "hiddenbased":
                String username = request.getParameter("username");
                System.out.println("Username from hiddenbased: "+username);
                request.setAttribute("msg1", "Username from the form was entered as: "+username);
                request.getRequestDispatcher("result.jsp").forward(request, response);
                break;
                
            case "urlbased":
                username = request.getParameter("username");
                System.out.println("Username from urlbased: "+username);
                request.setAttribute("msg2", "Username from URL: "+username);
                request.getRequestDispatcher("result.jsp").forward(request, response);
                break;
                
            default:
                throw new AssertionError();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
