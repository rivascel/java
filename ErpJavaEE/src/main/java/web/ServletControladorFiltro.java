package web;

import dominio.Cabpedidoven;
import dominio.CabpedidovenPK;
import dominio.Clientes;
import dominio.Detpedidoventas;
import java.io.IOException;
import java.text.*;
import java.util.*;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import servicio.PedidoService;

@WebServlet("/ServletControladorFiltro")
public class ServletControladorFiltro extends HttpServlet {

    @Inject
    PedidoService pedidoservice;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "edit":
                    this.editarPedido(request, response);
                    break;
                case "delete":
                    this.eliminarPedido(request, response);
                    break;
                case "search":
                    this.buscarPedido(request, response);
                    break;
                default:
                    this.porDefecto(request, response);
            }
        } else {
            this.porDefecto(request, response);
        }
    }

    private void porDefecto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Detpedidoventas> detpedido = pedidoservice.listarPedidosVentas();
        //System.out.println("detpedido = " + detpedido);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("detpedido", detpedido);
        sesion.setAttribute("total lineas", detpedido.size());

        response.sendRedirect("pedidoCompras.jsp");

        //String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        //request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void editarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idPEdido y tipoOrden
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        String tipoOrden = request.getParameter("tipoOrden");
        Detpedidoventas pedido = new Detpedidoventas(idPedido, tipoOrden);
        List<Detpedidoventas> detpedido = pedidoservice.encontrarPorIdPedidoTipoOrden(pedido);
        System.out.println("detpedido = " + detpedido);
        request.setAttribute("detpedido", detpedido);
        String jspEditar = "/WEB-INF/paginas/pedidos/modificarPedidos.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
        private void buscarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        String tipoOrden = request.getParameter("tipoOrden");
        Detpedidoventas pedido = new Detpedidoventas(idPedido, tipoOrden);
        List<Detpedidoventas> detpedido = pedidoservice.encontrarPorIdPedidoTipoOrden(pedido);
        System.out.println("detpedido = " + detpedido);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("detpedido", detpedido);
        request.setAttribute("detpedido", detpedido);
        String jspFiltrado = "/WEB-INF/paginas/pedidos/filtrarPedido.jsp";
        request.getRequestDispatcher(jspFiltrado).forward(request, response);
        //response.sendRedirect("filtrarPedido.jsp");
    }

    private void eliminarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario modificarPedido
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        String tipoOrden = request.getParameter("tipoOrden");
        Detpedidoventas detpedidoventas = new Detpedidoventas(idPedido, tipoOrden);
        pedidoservice.eliminarPedido(detpedidoventas);
        this.porDefecto(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "add":
                    this.agregarPedido(request, response);
                    break;
                case "modificar":
                    this.modificarPedido(request, response);
                    break;

                default:
                    this.porDefecto(request, response);
            }
        } else {
            this.porDefecto(request, response);
        }
    }

    private void agregarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores 

            Integer idPedido = Integer.parseInt(request.getParameter("idOrden"));
            String tipoOrden = request.getParameter("tipOrden");

            //DetpedidoventasPK clavePK = new DetpedidoventasPK(idPedido, tipoOrden);
            String fechastr = request.getParameter("fecha");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = sdf.parse(fechastr);

            String codigoProducto = request.getParameter("codProd");
            String nombreProducto = request.getParameter("nomProd");
            Integer cantidad = Integer.parseInt(request.getParameter("cant"));
            Double precio = Double.parseDouble(request.getParameter("precio"));
            
            Double total_Calculo = cantidad * precio; 
            Double total = total_Calculo;
            request.setAttribute("total", total);
            Float porcDscto = Float.parseFloat(request.getParameter("porcDescto"));

            Float PorcIva = Float.parseFloat(request.getParameter("porcIva"));
            Float porcRteFte = Float.parseFloat(request.getParameter("porcRteFte"));
            
            Double dscto_calc = total * porcDscto/100;
            Double descuento = dscto_calc;
            request.setAttribute("descuento", descuento);
            
            Double iva_calc = total * PorcIva/100;
            Double iva = iva_calc;
            request.setAttribute("iva", iva);
            
            Double rteFte_calc = total * porcRteFte/100;
            Double rteFte = rteFte_calc;
            request.setAttribute("rteFte", rteFte);

            //Integer idClienteTemp = request.getAttribute("idClientes"));
            //Object idClienteObj = (Object)idClienteTemp;
            Clientes idCliente = (Clientes) request.getAttribute(request.getParameter("idClientes"));

            double Total = 0;
            String totalString = request.getParameter("Total");
            if (totalString != null && !"".equals(totalString)) {
                total = Double.parseDouble(totalString);
            }

            //Creamos el objeto de pedido (modelo)
            Detpedidoventas detpedidoventas = new Detpedidoventas(idPedido, tipoOrden, fecha, codigoProducto,
                    nombreProducto, cantidad, precio, total, porcDscto, porcRteFte, PorcIva, rteFte, iva,
                    descuento, idCliente);

//            Insertamos el nuevo objeto en la base de datos
            pedidoservice.registrarPedido(detpedidoventas);
            //System.out.println("registrosModificados = " + registrosModificados);
            //Redirigimos hacia accion por default
            this.porDefecto(request, response);
        } catch (ParseException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void modificarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        try {
            
            Integer idPedido = Integer.parseInt(request.getParameter("idPedido"));
            String tipoOrden = request.getParameter("tipOrden");

            String fechastr = request.getParameter("fecha");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = sdf.parse(fechastr);

            String codigoProducto = request.getParameter("codigo");
            String nombreProducto = request.getParameter("nombre");
            Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));
            Double precio = Double.parseDouble(request.getParameter("precio"));
            
            Double total_Calculo = cantidad * precio; 
            Double total = total_Calculo;
            request.setAttribute("total", total);
            
            Float porcDscto = Float.parseFloat(request.getParameter("porcdescto"));
            Float PorcIva = Float.parseFloat(request.getParameter("pociva"));
            Float porcRteFte = Float.parseFloat(request.getParameter("porcrtefte"));
            
            Double dscto_calc = total * porcDscto/100;
            Double descuento = dscto_calc;
            request.setAttribute("descuento", descuento);
            
            Double iva_calc = total * PorcIva/100;
            Double iva = iva_calc;
            request.setAttribute("iva", iva);
            
            Double rteFte_calc = total * porcRteFte/100;
            Double rteFte = rteFte_calc;
            request.setAttribute("rteFte", rteFte);
            
            Clientes idCliente = (Clientes) request.getAttribute(request.getParameter("idClientes"));

            //Creamos el objeto de cliente (modelo)
            Detpedidoventas detpedidoventas = new Detpedidoventas(idPedido, tipoOrden, fecha, codigoProducto,
                    nombreProducto, cantidad, precio, total, porcDscto, porcRteFte, PorcIva, rteFte, iva,
                    descuento, idCliente);

            pedidoservice.modificarPedido(detpedidoventas);

            //Redirigimos hacia accion por default
            this.porDefecto(request, response);

        } catch (ParseException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
   
}
