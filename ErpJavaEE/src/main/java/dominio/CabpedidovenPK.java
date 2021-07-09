package dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class CabpedidovenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pedido")
    private int idPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_orden")
    private String tipoOrden;

    public CabpedidovenPK() {
    }

    public CabpedidovenPK(int idPedido, String tipoOrden) {
        this.idPedido = idPedido;
        this.tipoOrden = tipoOrden;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(String tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPedido;
        hash += (tipoOrden != null ? tipoOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabpedidovenPK)) {
            return false;
        }
        CabpedidovenPK other = (CabpedidovenPK) object;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if ((this.tipoOrden == null && other.tipoOrden != null) || (this.tipoOrden != null && !this.tipoOrden.equals(other.tipoOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.CabpedidovenPK[ idPedido=" + idPedido + ", tipoOrden=" + tipoOrden + " ]";
    }
    
}
