
<%@page import="com.emergentes.modelo.productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    productos item = (productos) request.getAttribute("miPro");
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
        <h1>Registro de productos</h1>
        <form action="Controlador_productos" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="<%=item.getId()%>"></td>
                </tr>
                <tr>
                    <td>Producto</td>
                    <td><input type="text" name="producto" value="<%=item.getProducto()%>"></td>
                </tr>
                <tr>
                    <td>Categoria</td>
                    <td><select name="categoria">
                            <option value="Electrodomesticos">Electrodomesticos</option>
                            <option value="Muebles">Muebles</option>

                        </select></td>
                </tr>
                <tr>
                    <td>Existencia</td>
                    <td><input type="text" name="existencia" value="<%=item.getExistencia()%>"></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio" value="<%=item.getPrecio()%>"></td>
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
