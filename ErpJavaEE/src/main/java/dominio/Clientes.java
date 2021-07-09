package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByIdClientes", query = "SELECT c FROM Clientes c WHERE c.idClientes = :idClientes"),
    @NamedQuery(name = "Clientes.findByTipoDoc", query = "SELECT c FROM Clientes c WHERE c.tipoDoc = :tipoDoc"),
    @NamedQuery(name = "Clientes.findByNombreCliente", query = "SELECT c FROM Clientes c WHERE c.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Clientes.findByTelefono", query = "SELECT c FROM Clientes c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Clientes.findByEmail", query = "SELECT c FROM Clientes c WHERE c.email = :email")})

public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_clientes")
    private Integer idClientes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_doc")
    private String tipoDoc;
    @Size(max = 45)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Size(max = 45)
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    private String email;
    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL)
    private List<Detpedidoventas> detpedidoventasList;

    public Clientes() {
    }

    public Clientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public Clientes(Integer idClientes, String tipoDoc) {
        this.idClientes = idClientes;
        this.tipoDoc = tipoDoc;
    }

    public Clientes(Integer idClientes, String tipoDoc, String nombreCliente, String telefono, String email) {
        this.idClientes = idClientes;
        this.tipoDoc = tipoDoc;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.email = email;
    }
    
    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Detpedidoventas> getDetpedidoventasList() {
        return detpedidoventasList;
    }

    public void setDetpedidoventasList(List<Detpedidoventas> detpedidoventasList) {
        this.detpedidoventasList = detpedidoventasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientes != null ? idClientes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idClientes == null && other.idClientes != null) || (this.idClientes != null && !this.idClientes.equals(other.idClientes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Clientes[ idClientes=" + idClientes + " ]";
    }

}
