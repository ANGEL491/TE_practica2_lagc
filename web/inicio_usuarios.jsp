<%@page import="com.emergentes.modelo.registro_usuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //la primera vez no existira el atributo "listaest"
    if (session.getAttribute("listausu") == null) {
        //si no existe el atributo inicializamos (creamos nosotros)
        ArrayList<registro_usuarios> listaux = new ArrayList<registro_usuarios>();
        //ahora si exite el atributo
        session.setAttribute("listausu", listaux);
    }
    //recuperamos los objetos de "listaest"
    ArrayList<registro_usuarios> lista = (ArrayList<registro_usuarios>) session.getAttribute("listausu");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de usuario registrados</h1>
        <!--como tiene parametros se hace con el metodo get-->
        <a href="Controlador_usuarios?op=1">Nuevo</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Correo electrónico</th>
                <th>Contraseña</th>
                <th></th>
                <th></th>
            </tr>
            <%                if (lista != null) {

                    for (registro_usuarios item : lista) {

            %>
            <tr>
                <td><%=item.getId()%></td>
                <td><%=item.getNombres()%></td>
                <td><%=item.getApellidos()%></td>
                <td><%=item.getCorreo()%></td>
                <td><%=item.getContrasena()%></td>
                <td>
                    <a href="Controlador_usuarios?op=2&id=<%=item.getId()%>">Editar</a>
                </td>
                <td>
                    <a href="Controlador_usuarios?op=3&id=<%=item.getId()%>"onclick="return confirm('esta seguro?')"
                       >Eliminar</a>

                </td>
            </tr>
            <%                    }

                }
            %>
        </table>
    </body>
</html>
