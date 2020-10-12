<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.inscripcion_curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("listacurso") == null) {
        ArrayList<inscripcion_curso> listaux = new ArrayList<inscripcion_curso>();
        session.setAttribute("listacurso", listaux);
    }
    ArrayList<inscripcion_curso> lista = (ArrayList<inscripcion_curso>) session.getAttribute("listacurso");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de inscripcion de curso</h1>
        <a href="Controlador_inscripcion_curso?op=1">Nuevo</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Curso</th>
                <th></th>
                <th></th>
            </tr>
            <%                if (lista != null) {

                    for (inscripcion_curso item : lista) {

            %>
            <tr>
                 <td><%=item.getId()%></td>
                <td><%=item.getNombre()%></td>
                <td><%=item.getApellido()%></td>
                <td><%=item.getCurso()%></td>
                <td>
                    <a href="Controlador_inscripcion_curso?op=2&id=<%=item.getId()%>">Editar</a>
                </td>
                <td>
                    <a href="Controlador_inscripcion_curso?op=3&id=<%=item.getId()%>"onclick="return confirm('esta seguro?')"
                       >Eliminar</a>

                </td>
            </tr>
            <%                    }

                }
            %>
        </table>
    </body>
</html>
