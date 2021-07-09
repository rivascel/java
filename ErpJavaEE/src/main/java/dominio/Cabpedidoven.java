package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
    @NamedQuery(name = "Cabpedidoven.findAll", query = "SELECT c FROM Cabpedidoven c"),
    @NamedQuery(name = "Cabpedidoven.findByIdPedido", query = "SELECT c FROM Cabpedidoven c WHERE c.cabpedidovenPK.idPedido = :idPedido"),
    @NamedQuery(name = "Cabpedidoven.findByTipoOrden", query = "SELECT c FROM Cabpedidoven c WHERE c.cabpedidovenPK.tipoOrden = :tipoOrden"),
    @NamedQuery(name = "Cabpedidoven.findByNombreCliente", query = "SELECT c FROM Cabpedidoven c WHERE c.nombreCliente = :nombreCliente")})

public class Cabpedidoven implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private CabpedidovenPK cabpedidovenPK;
    @Size(max = 45)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_orden")
    private Double totalOrden;
    @Column(name = "total_iva")
    private Double totalIva;
    @Column(name = "total_rtefte")
    private Double totalRtefte;
    @Column(name = "total_descto")
    private Double totalDescto;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_clientes")
    @ManyToOne
    private Clientes idCliente;

    public Cabpedidoven() {
    }

    public Cabpedidoven(CabpedidovenPK cabpedidovenPK) {
        this.cabpedidovenPK = cabpedidovenPK;
    }

    public Cabpedidoven(int idPedido, String tipoOrden) {
        this.cabpedidovenPK = new CabpedidovenPK(idPedido, tipoOrden);
    }

    public CabpedidovenPK getCabpedidovenPK() {
        return cabpedidovenPK;
    }

    public void setCabpedidovenPK(CabpedidovenPK cabpedidovenPK) {
        this.cabpedidovenPK = cabpedidovenPK;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalOrden() {
        return totalOrden;
    }

    public void setTotalOrden(Double totalOrden) {
        this.totalOrden = totalOrden;
    }

    public Double getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(Double totalIva) {
        this.totalIva = totalIva;
    }

    public Double getTotalRtefte() {
        return totalRtefte;
    }

    public void setTotalRtefte(Double totalRtefte) {
        this.totalRtefte = totalRtefte;
    }

    public Double getTotalDescto() {
        return totalDescto;
    }

    public void setTotalDescto(Double totalDescto) {
        this.totalDescto = totalDescto;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabpedidovenPK != null ? cabpedidovenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cabpedidoven)) {
            return false;
        }
        Cabpedidoven other = (Cabpedidoven) object;
        if ((this.cabpedidovenPK == null && other.cabpedidovenPK != null) || (this.cabpedidovenPK != null && !this.cabpedidovenPK.equals(other.cabpedidovenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Cabpedidoven[ cabpedidovenPK=" + cabpedidovenPK + " ]";
    }
    
}
