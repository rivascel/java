<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>

        <title>Pedido de Compras</title>
    </head>
    <body>
        <!--Cabecero-->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletControladorFiltro?accion=modificar"
              method="POST" class="was-validated">

            <!--Botones de navegacion-->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"/>


            <section id="detalle">

                <div class="container">
                    <div class="row">
                        <div class="col-md-9">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Listado de Pedidos</h4>
                                </div>
                                <div class="card-body" style="overflow:auto; width:100%; height:130%">
                                    <table class="table table-striped">
                                        <thead class="thead-dark">
                                            <tr>
                                                <th>No. Orden</th><th>Tipo Orden</th>
                                                <th>Fecha</th><th>Cod Prod</th><th>Nom Prod</th>
                                                <th>Cant</th><th>Precio</th><th>Total</th>
                                                <th>% Descto</th><th>% IVA</th><th>% Rte Fte</th>
                                                <th>Descuento</th><th>Iva</th><th>RteFte</th><th>Id Cliente</th>
                                                
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <!-- Iteramos cada elemento de la lista de clientes -->
                                            <c:forEach var="pedido" items="${detpedido}"  >
                                            <c:forEach var="total" items="${total}"></c:forEach> 
                                            <c:forEach var="descuento" items="${descuento}"></c:forEach> 
                                            <c:forEach var="iva" items="${iva}"></c:forEach> 
                                            <c:forEach var="rteFte" items="${rteFte}"></c:forEach> 
                                                <tr>
                                                    <td style='visibility:hidden;'><input type="number" name="idPedido" value="${pedido.idPedido}"/></td>
                                                    <td style='visibility:hidden;'><input type="text" name="tipOrden" value="${pedido.tipoOrden}"/></td>
                                                    <td><input type="date" name="fecha" value="${pedido.date}"/></td> 
                                                    <td><input type="text" name="codigo" value="${pedido.codProducto}"/></td> 
                                                    <td><input type="text" name="nombre" value="${pedido.nombreProducto}"/></td>
                                                    <td><input type="number" name="cantidad" value="${pedido.cantidad}"/></td>
                                                    <td><input type="number" name="precio" value="${pedido.precio}"/></td>
                                                    <td style='visibility:hidden;'><input type="number" name="total" value="${total}"/></td>
                                                    <td><input type="number" name="porcdescto" value="${pedido.porcDescto}"/></td>
                                                    <td><input type="number" name="pociva" value="${pedido.porcIva}"/></td>
                                                    <td><input type="number" name="porcrtefte" value="${pedido.porRteFte}"/></td>
                                                    <td style="visibility:hidden">${descuento}</td>
                                                    <td style="visibility:hidden">${iva}</td>
                                                    <td style="visibility:hidden">${rteFte}</td>
                                                    <td><input type="number" name="idClientes" value="${pedido.clientes}"/></td>
                                                </tr>   
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>

        <!--Pie de Pagina-->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>