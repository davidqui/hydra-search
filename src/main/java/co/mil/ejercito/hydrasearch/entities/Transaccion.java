/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "\"TRANSACCION\"")
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transaccion")
    private Long idTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_transaccion")
    private long idTipoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_transaccion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion_calculada")
    private long calificacionCalculada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "usuario_validador")
    private String usuarioValidador;
    @ManyToMany(mappedBy = "transaccionCollection")
    private Collection<Amenaza> amenazaCollection;
    @JoinTable(name = "FACTORES_TRANSACCION", joinColumns = {
        @JoinColumn(name = "id_transaccion", referencedColumnName = "id_transaccion")}, inverseJoinColumns = {
        @JoinColumn(name = "id_factores", referencedColumnName = "id_factores")})
    @ManyToMany
    private Collection<FactoresInestabilidad> factoresInestabilidadCollection;
    @JoinColumn(name = "id_clasificacion", referencedColumnName = "id_clasificacion")
    @ManyToOne(optional = false)
    private Clasificacion idClasificacion;
    @JoinColumn(name = "id_credibilidad", referencedColumnName = "id_credibilidad")
    @ManyToOne(optional = false)
    private Credibilidad idCredibilidad;
    @JoinColumn(name = "id_documento", referencedColumnName = "id_documento")
    @ManyToOne(optional = false)
    private Documento idDocumento;
    @JoinColumn(name = "id_exactitud", referencedColumnName = "id_exactitud")
    @ManyToOne(optional = false)
    private Exactitud idExactitud;
    @JoinColumn(name = "id_transicion", referencedColumnName = "id_transicion")
    @ManyToOne(optional = false)
    private Transicion idTransicion;

    public Transaccion() {
    }

    public Transaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Transaccion(Long idTransaccion, long idTipoTransaccion, Date fechaTransaccion, long calificacionCalculada, String descripcion, String usuarioValidador) {
        this.idTransaccion = idTransaccion;
        this.idTipoTransaccion = idTipoTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.calificacionCalculada = calificacionCalculada;
        this.descripcion = descripcion;
        this.usuarioValidador = usuarioValidador;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public long getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(long idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public long getCalificacionCalculada() {
        return calificacionCalculada;
    }

    public void setCalificacionCalculada(long calificacionCalculada) {
        this.calificacionCalculada = calificacionCalculada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuarioValidador() {
        return usuarioValidador;
    }

    public void setUsuarioValidador(String usuarioValidador) {
        this.usuarioValidador = usuarioValidador;
    }

    public Collection<Amenaza> getAmenazaCollection() {
        return amenazaCollection;
    }

    public void setAmenazaCollection(Collection<Amenaza> amenazaCollection) {
        this.amenazaCollection = amenazaCollection;
    }

    public Collection<FactoresInestabilidad> getFactoresInestabilidadCollection() {
        return factoresInestabilidadCollection;
    }

    public void setFactoresInestabilidadCollection(Collection<FactoresInestabilidad> factoresInestabilidadCollection) {
        this.factoresInestabilidadCollection = factoresInestabilidadCollection;
    }

    public Clasificacion getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Clasificacion idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public Credibilidad getIdCredibilidad() {
        return idCredibilidad;
    }

    public void setIdCredibilidad(Credibilidad idCredibilidad) {
        this.idCredibilidad = idCredibilidad;
    }

    public Documento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Documento idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Exactitud getIdExactitud() {
        return idExactitud;
    }

    public void setIdExactitud(Exactitud idExactitud) {
        this.idExactitud = idExactitud;
    }

    public Transicion getIdTransicion() {
        return idTransicion;
    }

    public void setIdTransicion(Transicion idTransicion) {
        this.idTransicion = idTransicion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idTransaccion);
        hash = 59 * hash + (int) (this.idTipoTransaccion ^ (this.idTipoTransaccion >>> 32));
        hash = 59 * hash + Objects.hashCode(this.fechaTransaccion);
        hash = 59 * hash + (int) (this.calificacionCalculada ^ (this.calificacionCalculada >>> 32));
        hash = 59 * hash + Objects.hashCode(this.descripcion);
        hash = 59 * hash + Objects.hashCode(this.usuarioValidador);
        hash = 59 * hash + Objects.hashCode(this.amenazaCollection);
        hash = 59 * hash + Objects.hashCode(this.factoresInestabilidadCollection);
        hash = 59 * hash + Objects.hashCode(this.idClasificacion);
        hash = 59 * hash + Objects.hashCode(this.idCredibilidad);
        hash = 59 * hash + Objects.hashCode(this.idDocumento);
        hash = 59 * hash + Objects.hashCode(this.idExactitud);
        hash = 59 * hash + Objects.hashCode(this.idTransicion);
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
        final Transaccion other = (Transaccion) obj;
        if (this.idTipoTransaccion != other.idTipoTransaccion) {
            return false;
        }
        if (this.calificacionCalculada != other.calificacionCalculada) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.usuarioValidador, other.usuarioValidador)) {
            return false;
        }
        if (!Objects.equals(this.idTransaccion, other.idTransaccion)) {
            return false;
        }
        if (!Objects.equals(this.fechaTransaccion, other.fechaTransaccion)) {
            return false;
        }
        if (!Objects.equals(this.amenazaCollection, other.amenazaCollection)) {
            return false;
        }
        if (!Objects.equals(this.factoresInestabilidadCollection, other.factoresInestabilidadCollection)) {
            return false;
        }
        if (!Objects.equals(this.idClasificacion, other.idClasificacion)) {
            return false;
        }
        if (!Objects.equals(this.idCredibilidad, other.idCredibilidad)) {
            return false;
        }
        if (!Objects.equals(this.idDocumento, other.idDocumento)) {
            return false;
        }
        if (!Objects.equals(this.idExactitud, other.idExactitud)) {
            return false;
        }
        if (!Objects.equals(this.idTransicion, other.idTransicion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "idTransaccion=" + idTransaccion + ", idTipoTransaccion=" + idTipoTransaccion + ", fechaTransaccion=" + fechaTransaccion + ", calificacionCalculada=" + calificacionCalculada + ", descripcion=" + descripcion + ", usuarioValidador=" + usuarioValidador + ", idClasificacion=" + idClasificacion + ", idCredibilidad=" + idCredibilidad + ", idDocumento=" + idDocumento + ", idExactitud=" + idExactitud + ", idTransicion=" + idTransicion + '}';
    }

       
}
