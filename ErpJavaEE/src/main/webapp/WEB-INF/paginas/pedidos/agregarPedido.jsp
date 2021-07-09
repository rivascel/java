<div class="modal fade" id="agregarPedidoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" style="overflow:auto; width:100%; height:130%">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Pedido</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <select class="agregar_fila" id="filas">
                    <option value="agregar" selected>Agregar</option>
                    <option value="quitar">Quitar</option>
                </select>
                <button id="btn_add">Filas</button>

                <form action="${pageContext.request.contextPath}/ServletControladorFiltro?accion=add"
                      method="POST" class="was-validated">
                    <button id="btn_save" type="submit">Guardar</button>
                    <table  id=tablaOrden>
                        <thead  id="headTablaOrden">
                            <tr><th>No. Orden</th><th>Tipo Orden</th><th>Fecha</th><th>Ref Producto</th>
                                <th>Nombre Producto</th><th>Cantidad</th><th>Precio</th><th>Total</th>
                                <th>Porc Descto</th><th>Porc Iva</th><th>Por RteFte</th>
                                <th>Dscto</th><th>Iva</th><th>RteFte</th>
                            </tr>
                        </thead>
                        <tbody id="bodyTablaOrden">
                        <c:forEach var="total" items="${total}"></c:forEach> 
                        <c:forEach var="descuento" items="${descuento}"></c:forEach> 
                        <c:forEach var="iva" items="${iva}"></c:forEach> 
                        <c:forEach var="rteFte" items="${rteFte}"></c:forEach> 
                        <tr>
                            <td><input type='number' name='idOrden' class='datoInput'></td>
                            <td><input type='text' name='tipOrden' class='datoInput'></td>
                            <td><input type='date' name='fecha' class='datoInput'></td>
                            <td><input type='text' name='codProd' class='datoInput'></td>
                            <td><input type='text' name='nomProd' class='datoInput'></td>
                            <td><input type='number' name='cant' class='datoInput'></td>
                            <td><input type='number' name='precio' class='datoInput'></td>
                            <td style='visibility:hidden;'></td>
                            <td><input type='number' name='porcDescto' class='datoInput'></td>
                            <td><input type='number' name='porcIva' class='datoInput'></td>
                            <td><input type='number' name='porcRteFte' class='datoInput'></td>
                            <td style='visibility:hidden;'></td>
                            <td style='visibility:hidden;'></td>
                            <td style='visibility:hidden;'></td>
                            <td><input type='number' name='idCliente' class='datoInput'></td>
                        </tr>
                        </tbody>  
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
