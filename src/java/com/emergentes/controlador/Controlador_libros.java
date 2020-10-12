package com.emergentes.controlador;

import com.emergentes.modelo.libros;
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
@WebServlet(name = "Controlador_libros", urlPatterns = {"/Controlador_libros"})
public class Controlador_libros extends HttpServlet {

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
            out.println("<title>Servlet Controlador_libros</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_libros at " + request.getContextPath() + "</h1>");
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
        ArrayList<libros> lista = (ArrayList<libros>) ses.getAttribute("listalibro");
        //nuevo
        if (op == 1) {
            libros p = new libros();
            request.setAttribute("miLibro", p);
            request.getRequestDispatcher("vista/editar_libro.jsp").forward(request, response);
        }
        //editar
        if (op == 2) {
            id = Integer.parseInt(request.getParameter("id"));
            pos = buscarIndice(request, id);
            libros p1 = lista.get(pos);
            request.setAttribute("miLibro", p1);
            request.getRequestDispatcher("vista/editar_libro.jsp").forward(request, response);
        }
        //eliminar
        if (op == 3) {
            id = Integer.parseInt(request.getParameter("id"));
            pos = buscarIndice(request, id);
            lista.remove(pos);
            ses.setAttribute("listalibro", lista);
            response.sendRedirect("inicio_libros.jsp");
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
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String resumen = request.getParameter("resumen");
        String medio = request.getParameter("medio");
        String nuevo = request.getParameter("nuevo");
        
        int pos;
        libros lib = new libros();

        lib.setId(id);
        lib.setTitulo(titulo);
        lib.setAutor(autor);
        lib.setResumen(resumen);
        lib.setMedio(medio);

        //verificammos
        //con esto obtenemos la session  y lo guardamos en la variable ses
        HttpSession ses = request.getSession();
        /*recuperamos los objetos de ses en lista*/
        ArrayList<libros> lista = (ArrayList<libros>) ses.getAttribute("listalibro");
        if (nuevo.equals("true")) {
            lista.add(lib);
        } else {
            //editar
            //buscar
            pos = buscarIndice(request, id);
            //reeplazar
            lista.set(pos, lib);

        }
        response.sendRedirect("inicio_libros.jsp");
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
        ArrayList<libros> lista = (ArrayList<libros>) ses.getAttribute("listalibro");
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
