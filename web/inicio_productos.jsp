<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("listapro") == null) {
        ArrayList<productos> listaux = new ArrayList<productos>();
        session.setAttribute("listapro", listaux);
    }
    ArrayList<productos> lista = (ArrayList<productos>) session.getAttribute("listapro");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de productos</h1>
        <a href="Controlador_productos?op=1">Nuevo</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Producto</th>
                <th>Categoria</th>
                <th>Existencia</th>
                <th>Precio</th>
                <th></th>
                <th></th>
            </tr>
            <%                if (lista != null) {

                    for (productos item : lista) {

            %>
            <tr>
                <td><%=item.getId()%></td>
                <td><%=item.getProducto()%></td>
                <td><%=item.getCategoria()%></td>
                <td><%=item.getExistencia()%></td>
                <td><%=item.getPrecio()%></td>
                <td>
                    <a href="Controlador_productos?op=2&id=<%=item.getId()%>">Editar</a>
                </td>
                <td>
                    <a href="Controlador_productos?op=3&id=<%=item.getId()%>"onclick="return confirm('esta seguro?')"
                       >Eliminar</a>

                </td>
            </tr>
            <%                    }

                }
            %>
        </table>
    </body>
</html>
