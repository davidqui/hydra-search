/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aherreram
 */
@Entity
@Table(name = "\"DOCUMENTO\"")
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento")
    private Long idDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_doc")
    private String nombreDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "url_documento")
    private String urlDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "extension")
    private String extension;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acceso_privado")
    private short accesoPrivado;
    @JoinColumn(name = "id_tipo_doc", referencedColumnName = "id_tipo_doc")
    @ManyToOne(optional = false)
    private TipoDoc idTipoDoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocumento")
    private Collection<Transaccion> transaccionCollection;

    public Documento() {
    }

    public Documento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Documento(Long idDocumento, String nombreDoc, String urlDocumento, Date fechaCreacion, String extension, short accesoPrivado) {
        this.idDocumento = idDocumento;
        this.nombreDoc = nombreDoc;
        this.urlDocumento = urlDocumento;
        this.fechaCreacion = fechaCreacion;
        this.extension = extension;
        this.accesoPrivado = accesoPrivado;
    }

    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public short getAccesoPrivado() {
        return accesoPrivado;
    }

    public void setAccesoPrivado(short accesoPrivado) {
        this.accesoPrivado = accesoPrivado;
    }

    public TipoDoc getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(TipoDoc idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
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
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.hydrasearch.entities.Documento[ idDocumento=" + idDocumento + " ]";
    }
    
}
