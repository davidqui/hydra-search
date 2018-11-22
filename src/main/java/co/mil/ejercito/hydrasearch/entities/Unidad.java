/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
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
@Table(name = "\"UNIDAD\"")
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u")})
public class Unidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unidad")
    private Long idUnidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "unidad")
    private String unidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidad")
    private Collection<Usuario> usuarioCollection;

    public Unidad() {
    }

    public Unidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Unidad(Long idUnidad, String unidad) {
        this.idUnidad = idUnidad;
        this.unidad = unidad;
    }

    public Long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idUnidad);
        hash = 79 * hash + Objects.hashCode(this.unidad);
        hash = 79 * hash + Objects.hashCode(this.usuarioCollection);
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
        final Unidad other = (Unidad) obj;
        if (!Objects.equals(this.unidad, other.unidad)) {
            return false;
        }
        if (!Objects.equals(this.idUnidad, other.idUnidad)) {
            return false;
        }
        if (!Objects.equals(this.usuarioCollection, other.usuarioCollection)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Unidad{" + "idUnidad=" + idUnidad + ", unidad=" + unidad + '}';
    }

}
