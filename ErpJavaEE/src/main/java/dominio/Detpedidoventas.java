package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;


@Entity
@NamedQueries({
    @NamedQuery(name = "Detpedidoventas.findAll", query = "SELECT d FROM Detpedidoventas d"),
    @NamedQuery(name = "Detpedidoventas.findByIdPedidoAndTipoOrden", query = "SELECT p FROM Detpedidoventas p WHERE p.idPedido = :idPedido and p.tipoOrden = :tipoOrden")
})
public class Detpedidoventas implements Serializable {

    private static final long serialVersionUID = 1L;
 
    @Id    
    private int consec;
    @Column(name = "id_Pedido")
    private int idPedido;
    @Column(name = "Tipo_Orden")
    private String tipoOrden;
    private Date date;
    @Column(name = "Cod_Producto")
    private String codProducto;
    @Column(name = "Nombre_Producto")
    private String nombreProducto;
    private Integer cantidad;
    private Double precio;
    private Double total;
    private Float porcDescto;
    private Float porcIva;
    private Float porRteFte;
    private Double descto;
    private Double iva;
    private Double rteFte;
    @JoinColumn(name = "id_clientes", referencedColumnName = "id_clientes")
    @ManyToOne(cascade = CascadeType.ALL)
    private Clientes clientes;

    public Detpedidoventas() {
    }

    public Detpedidoventas(int idPedido, String tipoOrden, Date date, String codProducto, String nombreProducto,
            Integer cantidad, Double precio, Double total, Float porcDescto, Float porcIva, Float porRteFte,
            Double descto, Double iva, Double rteFte, Clientes clientes) {
        
//        this.consec= consec;
        this.idPedido =  idPedido;
        this.tipoOrden =  tipoOrden;
        this.date = date;
        this.codProducto = codProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.porcDescto = porcDescto;
        this.porcIva = porcIva;
        this.porRteFte = porRteFte;
        this.descto = descto;
        this.iva = iva;
        this.rteFte = rteFte;
        this.clientes = clientes;
    }
    
    public Detpedidoventas(Date date, String codProducto, String nombreProducto,
            Integer cantidad, Double precio, Double total, Float porcDescto, Float porcIva, Float porRteFte,
            Double descto, Double iva, Double rteFte, Clientes clientes) {
        
        this.date = date;
        this.codProducto = codProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.porcDescto = porcDescto;
        this.porcIva = porcIva;
        this.porRteFte = porRteFte;
        this.descto = descto;
        this.iva = iva;
        this.rteFte = rteFte;
        this.clientes = clientes;
    }

    public Detpedidoventas (int idPedido, String tipoOrden){
        this.idPedido =  idPedido;
        this.tipoOrden =  tipoOrden;
    }
    
  //  public int getConsec() {
  //      return consec;
  //  }

  //  public void setConsec(int consec) {
  //      this.consec = consec;
  //  }
    
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Float getPorcDescto() {
        return porcDescto;
    }

    public void setPorcDescto(Float porcDescto) {
        this.porcDescto = porcDescto;
    }

    public Float getPorcIva() {
        return porcIva;
    }

    public void setPorcIva(Float porcIva) {
        this.porcIva = porcIva;
    }

    public Float getPorRteFte() {
        return porRteFte;
    }

    public void setPorRteFte(Float porRteFte) {
        this.porRteFte = porRteFte;
    }

    public Double getDescto() {
        return descto;
    }

    public void setDescto(Double descto) {
        this.descto = descto;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getRteFte() {
        return rteFte;
    }

    public void setRteFte(Double rteFte) {
        this.rteFte = rteFte;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idPedido;
        hash = 97 * hash + Objects.hashCode(this.tipoOrden);
        hash = 97 * hash + Objects.hashCode(this.date);
        hash = 97 * hash + Objects.hashCode(this.codProducto);
        hash = 97 * hash + Objects.hashCode(this.nombreProducto);
        hash = 97 * hash + Objects.hashCode(this.cantidad);
        hash = 97 * hash + Objects.hashCode(this.precio);
        hash = 97 * hash + Objects.hashCode(this.total);
        hash = 97 * hash + Objects.hashCode(this.porcDescto);
        hash = 97 * hash + Objects.hashCode(this.porcIva);
        hash = 97 * hash + Objects.hashCode(this.porRteFte);
        hash = 97 * hash + Objects.hashCode(this.descto);
        hash = 97 * hash + Objects.hashCode(this.iva);
        hash = 97 * hash + Objects.hashCode(this.rteFte);
        hash = 97 * hash + Objects.hashCode(this.clientes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Detpedidoventas other = (Detpedidoventas) obj;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if (!Objects.equals(this.tipoOrden, other.tipoOrden)) {
            return false;
        }
        if (!Objects.equals(this.codProducto, other.codProducto)) {
            return false;
        }
        if (!Objects.equals(this.nombreProducto, other.nombreProducto)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.porcDescto, other.porcDescto)) {
            return false;
        }
        if (!Objects.equals(this.porcIva, other.porcIva)) {
            return false;
        }
        if (!Objects.equals(this.porRteFte, other.porRteFte)) {
            return false;
        }
        if (!Objects.equals(this.descto, other.descto)) {
            return false;
        }
        if (!Objects.equals(this.iva, other.iva)) {
            return false;
        }
        if (!Objects.equals(this.rteFte, other.rteFte)) {
            return false;
        }
        if (!Objects.equals(this.clientes, other.clientes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Detpedidoventas{" + "consec=" + consec +"idPedido=" + idPedido + ", tipoOrden=" + tipoOrden + ", date=" + date + ", codProducto=" + codProducto + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad + ", precio=" + precio + ", total=" + total + ", porcDescto=" + porcDescto + ", porcIva=" + porcIva + ", porRteFte=" + porRteFte + ", descto=" + descto + ", iva=" + iva + ", rteFte=" + rteFte + ", clientes=" + clientes + '}';
    }

    
}
