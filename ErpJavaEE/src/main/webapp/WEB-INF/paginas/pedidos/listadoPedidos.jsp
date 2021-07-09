<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Pedidos</title>
    </head>

    <section id="detalle">

        <div class="container">
            <div class="row">
                <div class="col-md-9">
                    <div class="card">
                        <div class="card-header">
                            <h4>Listado de Pedidos</h4>
                        </div>
                         
                        <table >
                            <thead >
                                <tr>
                                     <th>No.Orden</th><th>Tipo</th><th>Fecha</th><th>Cod Prod</th>
                                     <th>Nom Prod</th>
                                    <th>Cant</th><th>Precio</th><th>Total</th>
                                    <th>% Descto</th><th>% IVA</th><th>% Rte Fte</th>
                                    <th>Dscto</th><th>IVA</th><th>Rte Fte</th>
                                </tr>
                            </thead>

                            <tbody>
                                <!-- Iteramos cada elemento de la lista de clientes -->
                                <c:forEach var="pedido" items="${detpedido}"  >
                                    <tr>
                                        <td>${pedido.idPedido}</td>
                                        <td>${pedido.tipoOrden}</td>
                                        <td>${pedido.date}</td> 
                                        <td>${pedido.codProducto}</td> 
                                        <td>${pedido.nombreProducto}</td>
                                        <td>${pedido.cantidad}</td>
                                        <td>${pedido.precio}</td>
                                        <td><fmt:formatNumber value="${pedido.total}" type="currency"/></td>
                                        <td>${pedido.porcDescto}</td>
                                        <td>${pedido.porcIva}</td>
                                        <td>${pedido.porRteFte}</td>
                                        <td>${pedido.descto}</td>
                                        <td>${pedido.iva}</td>
                                        <td>${pedido.rteFte}</td>
                                    </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Agregar pedido MODAL -->
    <jsp:include page="/WEB-INF/paginas/pedidos/agregarPedido.jsp"/>
</html>