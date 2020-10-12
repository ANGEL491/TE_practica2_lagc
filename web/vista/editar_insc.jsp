<%@page import="com.emergentes.modelo.inscripcion_curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    inscripcion_curso item = (inscripcion_curso) request.getAttribute("minsc");
    boolean nuevo = true;
    if (item.getId() > 0) {
        nuevo = false;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de inscripcion de curso</h1>
        <form action="Controlador_inscripcion_curso" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="<%=item.getId()%>"></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="<%=item.getNombre()%>"></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellido" value="<%=item.getApellido()%>"></td>
                </tr>
                <tr>
                    <td>Curso</td>
                    <td><select name="curso">
                            <option value="Estadistica">Estadistica</option>
                            <option value="Programacion">Programación</option>

                        </select></td>

                </tr>
                <tr>
                    <!--mandamos un parametro oculto para ver si el registro es nuevo o no-->
                <input type="hidden" name="nuevo" value="<%=nuevo%>">
                <td></td>
                <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
