/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "\"FACTORES_INESTABILIDAD\"")
@NamedQueries({
    @NamedQuery(name = "FactoresInestabilidad.findAll", query = "SELECT f FROM FactoresInestabilidad f")})
public class FactoresInestabilidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factores")
    private Long idFactores;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nombre")
    private String nombre;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactores")
    private Collection<FactoresTransaccion> factoresTransaccionCollection;

    public FactoresInestabilidad() {
    }

    public FactoresInestabilidad(Long idFactores) {
        this.idFactores = idFactores;
    }

    public FactoresInestabilidad(Long idFactores, String nombre) {
        this.idFactores = idFactores;
        this.nombre = nombre;
    }

    public Long getIdFactores() {
        return idFactores;
    }

    public void setIdFactores(Long idFactores) {
        this.idFactores = idFactores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<FactoresTransaccion> getFactoresTransaccionCollection() {
        return factoresTransaccionCollection;
    }

    public void setFactoresTransaccionCollection(Collection<FactoresTransaccion> factoresTransaccionCollection) {
        this.factoresTransaccionCollection = factoresTransaccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactores != null ? idFactores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactoresInestabilidad)) {
            return false;
        }
        FactoresInestabilidad other = (FactoresInestabilidad) object;
        if ((this.idFactores == null && other.idFactores != null) || (this.idFactores != null && !this.idFactores.equals(other.idFactores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.hydrasearch.entities.FactoresInestabilidad[ idFactores=" + idFactores + " ]";
    }
    
}
