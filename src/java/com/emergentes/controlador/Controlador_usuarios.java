package com.emergentes.controlador;

import com.emergentes.modelo.registro_usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Controlador_usuarios", urlPatterns = {"/Controlador_usuarios"})
public class Controlador_usuarios extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_usuarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_usuarios at " + request.getContextPath() + "</h1>");
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

        int op = Integer.parseInt(request.getParameter("op"));
        int id, pos;

        HttpSession ses = request.getSession();
        ArrayList<registro_usuarios> lista = (ArrayList<registro_usuarios>) ses.getAttribute("listausu");
        //nuevo
        if (op == 1) {
            registro_usuarios p = new registro_usuarios();
            request.setAttribute("miUsuario", p);
            request.getRequestDispatcher("vista/editar_usuarios.jsp").forward(request, response);
        }
        //editar
        if (op == 2) {
            id = Integer.parseInt(request.getParameter("id"));
            pos = buscarIndice(request, id);
            registro_usuarios p1 = lista.get(pos);
            request.setAttribute("miUsuario", p1);
            request.getRequestDispatcher("vista/editar_usuarios.jsp").forward(request, response);
        }
        //eliminar
        if (op == 3) {
            id = Integer.parseInt(request.getParameter("id"));
            pos = buscarIndice(request, id);
            lista.remove(pos);
            ses.setAttribute("listausu", lista);
            response.sendRedirect("inicio_usuarios.jsp");
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
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String  correo= request.getParameter("correo");
        String  contrasena= request.getParameter("contrasena");
         String nuevo = request.getParameter("nuevo");
         
        int pos;
        registro_usuarios regu = new registro_usuarios();
        
        regu.setId(id);
        regu.setNombres(nombres);
        regu.setApellidos(apellidos);
        regu.setCorreo(correo);
        regu.setContrasena(contrasena);

        //verificammos
        //con esto obtenemos la session  y lo guardamos en la variable ses
        HttpSession ses = request.getSession();
        /*recuperamos los objetos de ses en lista*/
        ArrayList<registro_usuarios> lista = (ArrayList<registro_usuarios>) ses.getAttribute("listausu");
        if (nuevo.equals("true")) {
            lista.add(regu);
        } else {
            //editar
            //buscar
            pos = buscarIndice(request, id);
            //reeplazar
            lista.set(pos, regu);
            
        }
        response.sendRedirect("inicio_usuarios.jsp");
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

    private int buscarIndice(HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        ArrayList<registro_usuarios> lista = (ArrayList<registro_usuarios>) ses.getAttribute("listausu");
        int i = 0;
        if (lista.size() > 0) {
            while (i < lista.size()) {
                if (lista.get(i).getId() == id) {
                    break;
                } else {
                    i++;
                }

            }
        }
        return i;
    }
}
