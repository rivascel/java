package datos;

import dominio.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class PedidoVentasDaoImpl implements PedidoventasDao {

    @PersistenceContext(unitName = "PedidoPU")
    EntityManager em;

    @Override
    public List<Cabpedidoven> findAllPedidoCab() {
        return em.createNamedQuery("Cabpedidoven.findAll").getResultList();
    }
    
    @Override
    public List<Detpedidoventas> findAllPedido() {
        return em.createNamedQuery("Detpedidoventas.findAll").getResultList();
    }

    @Override
    public List<Cabpedidoven> findPedidoByIdCab(CabpedidovenPK cabpedidovenPK) {
        Query query = em.createQuery("SELECT d from CabpedidovenPK d WHERE d.idPedido= :idPedido and "
                + "d.tipoOrden= :tipoOrden");
        query.setParameter("idPedido", cabpedidovenPK.getIdPedido());
        query.setParameter("tipoOrden", cabpedidovenPK.getTipoOrden());
        return query.getResultList();
    }
    
    @Override
    public List<Detpedidoventas> findPedidoById(Detpedidoventas detpedidoventas) {

        Query query = em.createQuery("SELECT d from Detpedidoventas d WHERE d.idPedido= :idPedido and "
                + "d.tipoOrden= :tipoOrden");
        query.setParameter("idPedido", detpedidoventas.getIdPedido());
        query.setParameter("tipoOrden", detpedidoventas.getTipoOrden());
        return query.getResultList();
    }

    @Override
    public void insertPedidoCab(CabpedidovenPK cabpedidovenPK) {
        em.persist(cabpedidovenPK);
    }
    
    @Override
    public void insertPedido(Detpedidoventas detpedidoventas) {
        em.persist(detpedidoventas);
    }

    @Override
    public void upgradePedidoCab(CabpedidovenPK cabpedidovenPK) {
        em.merge(cabpedidovenPK);

    }
    
    @Override
    public void upgradePedido(Detpedidoventas detpedidoventas) {

//        Query query = em.createQuery("UPDATE Detpedidoventas d SET d.codProducto = codProducto, "
//                + "d.nombreProducto = nombreProducto, d.cantidad = cantidad, d.precio = precio, d.total = total,"
//                + " d.porcDescto = porcDescto, d.porcIva = porcIva, d.porcRteFte = porcRteFte, d.descto = descto, "
//                + "d.iva = iva, d.rteFte = rteFte WHERE  d.idPedido = :idPedido and d.tipoOrden = :tipoOrden");
//        
//
//        query.setParameter("idPedido", detpedidoventas.getIdPedido());
//        query.setParameter("tipoOrden", detpedidoventas.getTipoOrden());
        
        em.merge(detpedidoventas);

    }
    
    @Override
    public void deletePedidoCab(CabpedidovenPK cabpedidovenPK) {
        em.remove(em.merge(cabpedidovenPK));

    }

    @Override
    public void deletePedido(Detpedidoventas detpedidoventas) {
        em.remove(em.merge(detpedidoventas));
    }
}
