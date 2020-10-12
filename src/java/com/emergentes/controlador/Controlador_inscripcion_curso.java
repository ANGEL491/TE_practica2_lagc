package com.emergentes.controlador;

import com.emergentes.modelo.inscripcion_curso;
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
@WebServlet(name = "Controlador_inscripcion_curso", urlPatterns = {"/Controlador_inscripcion_curso"})
public class Controlador_inscripcion_curso extends HttpServlet {

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
            out.println("<title>Servlet Controlador_inscripcion_curso</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_inscripcion_curso at " + request.getContextPath() + "</h1>");
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
        ArrayList<inscripcion_curso> lista = (ArrayList<inscripcion_curso>) ses.getAttribute("listacurso");
        //nuevo
        if (op == 1) {
            inscripcion_curso insc = new inscripcion_curso();
            request.setAttribute("minsc", insc);
            request.getRequestDispatcher("vista/editar_insc.jsp").forward(request, response);
        }
        /*editar*/
        if (op == 2) {
            id = Integer.parseInt(request.getParameter("id"));
            pos=buscarIndice(request, id);
            inscripcion_curso insc1 = lista.get(pos);
            request.setAttribute("minsc", insc1);
            request.getRequestDispatcher("vista/editar_insc.jsp").forward(request, response);
        }
        /*eliminar*/
        if (op == 3) {
            id = Integer.parseInt(request.getParameter("id"));
            pos = buscarIndice(request, id);
            lista.remove(pos);
            ses.setAttribute("listacurso", lista);
            response.sendRedirect("inicio_inscripcion_curso.jsp");
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
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String curso = request.getParameter("curso");
        String nuevo = request.getParameter("nuevo");

        int pos;
        
        inscripcion_curso insc = new inscripcion_curso();
        
        insc.setId(id);
        insc.setNombre(nombre);
        insc.setApellido(apellido);
        insc.setCurso(curso);

        HttpSession ses = request.getSession();
        ArrayList<inscripcion_curso> lista = (ArrayList<inscripcion_curso>) ses.getAttribute("listacurso");
        
        if (nuevo.equals("true")) {
            lista.add(insc);
        } else {
            pos = buscarIndice(request, id);
            lista.set(pos, insc);
        }
        response.sendRedirect("inicio_inscripcion_curso.jsp");
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
        ArrayList<inscripcion_curso> lista = (ArrayList<inscripcion_curso>) ses.getAttribute("listacurso");
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
