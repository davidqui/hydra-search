/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aherreram
 */
@Entity
@Table(name = "\"TRANSICION\"")
@NamedQueries({
    @NamedQuery(name = "Transicion.findAll", query = "SELECT t FROM Transicion t")})
public class Transicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transicion")
    private Long idTransicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTransicion")
    private Collection<Transaccion> transaccionCollection;
    @JoinColumn(name = "login_usuario", referencedColumnName = "login")
    @ManyToOne(optional = false)
    private Usuario loginUsuario;

    public Transicion() {
    }

    public Transicion(Long idTransicion) {
        this.idTransicion = idTransicion;
    }

    public Transicion(Long idTransicion, String estado) {
        this.idTransicion = idTransicion;
        this.estado = estado;
    }

    public Long getIdTransicion() {
        return idTransicion;
    }

    public void setIdTransicion(Long idTransicion) {
        this.idTransicion = idTransicion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }

    public Usuario getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(Usuario loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransicion != null ? idTransicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transicion)) {
            return false;
        }
        Transicion other = (Transicion) object;
        if ((this.idTransicion == null && other.idTransicion != null) || (this.idTransicion != null && !this.idTransicion.equals(other.idTransicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.hydrasearch.entities.Transicion[ idTransicion=" + idTransicion + " ]";
    }
    
}
