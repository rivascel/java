package datos;

import dominio.*;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PedidoventasDao {
    
    public List<Cabpedidoven> findAllPedidoCab();
    
    public List<Detpedidoventas> findAllPedido();
    
    public List<Cabpedidoven> findPedidoByIdCab(CabpedidovenPK cabpedidovenPK);

    public List<Detpedidoventas> findPedidoById(Detpedidoventas detpedidoventas);

    public void insertPedidoCab(CabpedidovenPK cabpedidovenPK);

    public void insertPedido(Detpedidoventas detpedidoventas);
    
    public void upgradePedidoCab(CabpedidovenPK cabpedidovenPK);
    
    public void upgradePedido(Detpedidoventas detpedidoventas);
    
    public void deletePedidoCab(CabpedidovenPK cabpedidovenPK);

    public void deletePedido(Detpedidoventas detpedidoventas);
    
}
