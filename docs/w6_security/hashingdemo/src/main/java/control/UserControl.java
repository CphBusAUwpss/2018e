package control;

import data.PasswordStorage;
import data.UserMapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Nov 24, 2016
 */
@WebServlet(name="UserControl", urlPatterns={"/UserControl","/index.jsp"}) //HER SÆTTES DENNE SERVLET TIL AT SVARE PÅ FORESPØRGSLER TIL index.jsp (hvilket er hvad Tomcat kigger efter, hvis intet andet er angivet i URLen
public class UserControl extends HttpServlet {
   UserMapper um = new UserMapper();
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String origin = request.getParameter("origin");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            if(request.getParameter("do")!=null && request.getParameter("do").equals("register")){
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            if(origin == null){
                //HER ER ÆNDRINGEN DER GØR AT MAN NU KAN TILGÅ DE "HEMMELIGE" FILER i WEB-INF
                
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//                request.getRequestDispatcher(email);("WEB-INFlogin.jsp"); //KAN MAN IKKE
            }else{
                switch(origin){
                    case "register" : 
                         try{
                             int age = Integer.parseInt(request.getParameter("age"));
                             double account = Double.parseDouble(request.getParameter("account"));
                         }
                         catch(NumberFormatException ex){
                             request.setAttribute("error", "ERROR! IT MUST BE A NUMBER");
                             request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                         }
                         System.out.println("INSIDE REGISTER");
                        if(password1 != null && password2 != null && email != null && username != null){
//                            if(password1.length() >= 8 && password1.equals(password2)){
                        System.out.println("Inside register check");
                            //Check here for valid email, password constraints, unique username etc...
                            register(username, password1, email);
                        System.out.println("After register");
                            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
//                            }
                        }
                        break;
                    case "login" :
                        System.out.println("Inside login");
                        if(login(username, password)){
                            request.getSession().setAttribute("username", username);
                            request.getRequestDispatcher("succes.jsp").forward(request, response);
                        }
                        break;
                    default:
                        response.sendRedirect("login.jsp");
                        break;
                }
            }
        } catch (PasswordStorage.CannotPerformOperationException ex) {
           ex.printStackTrace(); //Write some error message back to user here...
       } catch (PasswordStorage.InvalidHashException ex) {
           ex.printStackTrace(); //And/Or here....
       }
    } 
    private void register(String username, String password, String email) throws PasswordStorage.CannotPerformOperationException{
        um.registerUser(username, password, email);
    }
    
    private boolean login(String username, String password) throws PasswordStorage.CannotPerformOperationException, PasswordStorage.InvalidHashException{
        return um.authenticate(username, password);
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
