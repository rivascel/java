package servicio;

import datos.PedidoventasDao;
import dominio.Cabpedidoven;
import dominio.CabpedidovenPK;
import dominio.Detpedidoventas;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.inject.Inject;

public class pedidoServiceImpl implements PedidoService {

    @Inject
    private PedidoventasDao pedidoventasDao;
    
    @Override
    public List<Cabpedidoven> listarPedidosVentasCab() {
        return pedidoventasDao.findAllPedidoCab();
    }
    
    @Override
    public List<Detpedidoventas> listarPedidosVentas() {
        return pedidoventasDao.findAllPedido();
    }

    @Override
    public List<Cabpedidoven> encontrarPorIdPedidoTipoOrdenCab(CabpedidovenPK cabpedidovenPK) {
        return pedidoventasDao.findPedidoByIdCab(cabpedidovenPK);
    }
    
    @Override
    public List<Detpedidoventas> encontrarPorIdPedidoTipoOrden(Detpedidoventas detpedidoventas) {
        return pedidoventasDao.findPedidoById(detpedidoventas);
    }
    
    @Override
    public void registrarPedidoCab(CabpedidovenPK cabpedidovenPK) {
        pedidoventasDao.insertPedidoCab(cabpedidovenPK);

    }

    @Override
    public void registrarPedido(Detpedidoventas detpedidoventas) {
        pedidoventasDao.insertPedido(detpedidoventas);
    }

    @Override
    public void modificarPedidoCab(CabpedidovenPK cabpedidovenPK) {
        pedidoventasDao.upgradePedidoCab(cabpedidovenPK);           
    }
    
    @Override
    public void modificarPedido(Detpedidoventas detpedidoventas) {
        pedidoventasDao.upgradePedido(detpedidoventas);           
 
    }

    @Override
    public void eliminarPedidoCab(CabpedidovenPK cabpedidovenPK) {
        pedidoventasDao.deletePedidoCab(cabpedidovenPK);
    }
    @Override
    public void eliminarPedido(Detpedidoventas detpedidoventas) {
        pedidoventasDao.deletePedido(detpedidoventas);
    }

    

}
