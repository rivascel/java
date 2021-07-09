package servicio;

import dominio.*;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PedidoService {
    
    public List<Cabpedidoven> listarPedidosVentasCab();
    
    public List<Detpedidoventas> listarPedidosVentas();
    
    public List<Cabpedidoven> encontrarPorIdPedidoTipoOrdenCab(CabpedidovenPK cabpedidovenPK);
    
    public List<Detpedidoventas> encontrarPorIdPedidoTipoOrden(Detpedidoventas detpedidoventas);
    
    public void registrarPedidoCab(CabpedidovenPK cabpedidovenPK);
        
    public void registrarPedido(Detpedidoventas detpedidoventas);

    public void modificarPedidoCab(CabpedidovenPK cabpedidovenPK);
    
    public void modificarPedido(Detpedidoventas detpedidoventas);
    
    public void eliminarPedidoCab(CabpedidovenPK cabpedidovenPK);
    
    public void eliminarPedido(Detpedidoventas detpedidoventas);
    
}
    

