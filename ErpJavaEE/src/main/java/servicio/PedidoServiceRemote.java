package servicio;

import dominio.Detpedidoventas;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface PedidoServiceRemote {
    public List<Detpedidoventas> listarPedidosVentas();
    
    public Detpedidoventas encontrarPorIdPedidoTipoOrden(Detpedidoventas detpedidoventas);
    
    public void registrarPedido(Detpedidoventas detpedidoventas);
    
    public void modificarPedido(Detpedidoventas detpedidoventas);
    
    public void eliminarPedido(Detpedidoventas detpedidoventas);
}
