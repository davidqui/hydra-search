/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "\"EXACTITUD\"")
@NamedQueries({
    @NamedQuery(name = "Exactitud.findAll", query = "SELECT e FROM Exactitud e")})
public class Exactitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_exactitud")
    private Long idExactitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private long valor;
    @OneToMany(mappedBy = "idExactitud")
    private Collection<Transaccion> transaccionCollection;

    public Exactitud() {
    }

    public Exactitud(Long idExactitud) {
        this.idExactitud = idExactitud;
    }

    public Exactitud(Long idExactitud, String nombre, long valor) {
        this.idExactitud = idExactitud;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Long getIdExactitud() {
        return idExactitud;
    }

    public void setIdExactitud(Long idExactitud) {
        this.idExactitud = idExactitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExactitud != null ? idExactitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exactitud)) {
            return false;
        }
        Exactitud other = (Exactitud) object;
        if ((this.idExactitud == null && other.idExactitud != null) || (this.idExactitud != null && !this.idExactitud.equals(other.idExactitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.hydrasearch.entities.Exactitud[ idExactitud=" + idExactitud + " ]";
    }
    
}
