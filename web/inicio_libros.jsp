
<%@page import="com.emergentes.modelo.libros"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //la primera vez no existira el atributo "listaest"
    if (session.getAttribute("listalibro") == null) {
        //si no existe el atributo inicializamos (creamos nosotros)
        ArrayList<libros> listaux = new ArrayList<libros>();
        //ahora si exite el atributo
        session.setAttribute("listalibro", listaux);
    }
    //recuperamos los objetos de "listaest"
    ArrayList<libros> lista = (ArrayList<libros>) session.getAttribute("listalibro");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Libros</h1>
        <!--como tiene parametros se hace con el metodo get-->
        <a href="Controlador_libros?op=1">Nuevo</a>
        <table border="1">
            <tr>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Resumén</th>
                <th>Medio</th>
                <th></th>
                <th></th>
            </tr>
            <%                if (lista != null) {

                    for (libros item : lista) {

            %>
            <tr>
                <td><%=item.getTitulo()%></td>
                <td><%=item.getAutor()%></td>
                <td><%=item.getResumen()%></td>
                <td><%=item.getMedio()%></td>
                <td>
                    <a href="Controlador_libros?op=2&id=<%=item.getId()%>">Editar</a>
                </td>
                <td>
                    <a href="Controlador_libros?op=3&id=<%=item.getId()%>"onclick="return confirm('esta seguro?')"
                       >Eliminar</a>

                </td>
            </tr>
            <%                    }

                }
            %>
        </table>
    </body>
</html>
