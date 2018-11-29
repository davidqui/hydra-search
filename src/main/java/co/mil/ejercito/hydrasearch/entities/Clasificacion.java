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
@Table(name = "\"CLASIFICACION\"")
@NamedQueries({
    @NamedQuery(name = "Clasificacion.findAll", query = "SELECT c FROM Clasificacion c")})
public class Clasificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clasificacion")
    private Long idClasificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "tipo")
    private String tipo;
    @JsonIgnore
    @OneToMany(mappedBy = "idClasificacion")
    private Collection<Documento> documentoCollection;

    public Clasificacion() {
    }

    public Clasificacion(Long idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public Clasificacion(Long idClasificacion, String tipo) {
        this.idClasificacion = idClasificacion;
        this.tipo = tipo;
    }

    public Long getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Long idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClasificacion != null ? idClasificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clasificacion)) {
            return false;
        }
        Clasificacion other = (Clasificacion) object;
        if ((this.idClasificacion == null && other.idClasificacion != null) || (this.idClasificacion != null && !this.idClasificacion.equals(other.idClasificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.hydrasearch.entities.Clasificacion[ idClasificacion=" + idClasificacion + " ]";
    }
    
}
