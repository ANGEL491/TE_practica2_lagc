
<%@page import="com.emergentes.modelo.registro_usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    registro_usuarios item = (registro_usuarios) request.getAttribute("miUsuario");
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
        <h1>Registro de usuarios</h1>
        <form action="Controlador_usuarios" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="<%=item.getId()%>"></td>
                </tr>
                <tr>
                    <td>Nombres</td>
                    <td><input type="text" name="nombres" value="<%=item.getNombres()%>"></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellidos" value="<%=item.getApellidos()%>"></td>
                </tr>
                <tr>
                    <td>Correo</td>
                    <td><input type="email" name="correo" value="<%=item.getCorreo()%>"></td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="password" name="contrasena" value="<%=item.getContrasena()%>"></td>
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
