

<%@page import="com.emergentes.modelo.libros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    libros item = (libros) request.getAttribute("miLibro");
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
        <h1>Registro de libros</h1>
        <form action="Controlador_libros" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="<%=item.getId()%>"></td>
                </tr>
                <tr>
                    <td>Titulo</td>
                    <td><input type="text" name="titulo" value="<%=item.getTitulo()%>"></td>
                </tr>
                <tr>
                    <td>Autor</td>
                    <td><input type="text" name="autor" value="<%=item.getAutor()%>"></td>
                </tr>
                <tr>
                    <td>Resumen</td>
                    <td><textarea name="resumen" cols="50" rows="6" values="<%=item.getResumen()%>"></textarea></td>
                </tr>
                <tr>
                    <td>Medio</td>
                </tr>
                <tr><td><input type="radio" name="medio" value="FISICO" checked="">FÍSICO</td></tr>
                <tr><td><input type="radio" name="medio" value="MAGNETICO" checked="">MAGNETICO</td></tr>

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
