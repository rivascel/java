<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="cabecera">
    <form method="get" action="${pageContext.request.contextPath}/ServletControladorFiltro">
        <div class="container">
            <label for="tipoOrden">Tipo Orden</label>
            <input id="tipOrden" type="text" class="form-control" name="tipoOrden" onclick="SelectName()" readonly>
        </div>
        <div class="container">
            <label for="idPedido">Numero Orden</label>
            <input id="numOrden" type="text" class="form-control" name="idPedido" >
        </div>
        <div>
            <input type="submit" value="search" name="accion">
            <input type="submit" value="edit" name="accion">
            <input type="submit" value="delete" name="accion">
        </div>
    </form>   
</section>

