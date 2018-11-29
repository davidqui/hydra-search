/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
@Table(name = "\"AMENAZA\"")
@NamedQueries({
    @NamedQuery(name = "Amenaza.findAll", query = "SELECT a FROM Amenaza a")})
public class Amenaza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_amenaza")
    private Long idAmenaza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "tipo")
    private String tipo;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAmenaza")
    private Collection <AmenazaTransaccion> amenazaTransaccionCollection;

    public Amenaza() {
    }

    public Amenaza(Long idAmenaza) {
        this.idAmenaza = idAmenaza;
    }

    public Amenaza(Long idAmenaza, String tipo) {
        this.idAmenaza = idAmenaza;
        this.tipo = tipo;
    }

    public Long getIdAmenaza() {
        return idAmenaza;
    }

    public void setIdAmenaza(Long idAmenaza) {
        this.idAmenaza = idAmenaza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Collection<AmenazaTransaccion> getAmenazaTransaccionCollection() {
        return amenazaTransaccionCollection;
    }

    public void setAmenazaTransaccionCollection(Collection<AmenazaTransaccion> amenazaTransaccionCollection) {
        this.amenazaTransaccionCollection = amenazaTransaccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmenaza != null ? idAmenaza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amenaza)) {
            return false;
        }
        Amenaza other = (Amenaza) object;
        if ((this.idAmenaza == null && other.idAmenaza != null) || (this.idAmenaza != null && !this.idAmenaza.equals(other.idAmenaza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.hydrasearch.entities.Amenaza[ idAmenaza=" + idAmenaza + " ]";
    }
    
}
