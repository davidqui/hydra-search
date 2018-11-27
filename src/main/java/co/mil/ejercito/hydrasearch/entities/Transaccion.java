/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

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
    @Column(name = "fecha_transaccion")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaTransaccion;
    @Column(name = "calificacion_calculada")
    private Long calificacionCalculada;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 60)
    @Column(name = "usuario_validador")
    private String usuarioValidador;
    @JoinColumn(name = "id_credibilidad", referencedColumnName = "id_credibilidad")
    @ManyToOne
    private Credibilidad idCredibilidad;
    @JoinColumn(name = "id_documento", referencedColumnName = "id_documento")
    @ManyToOne
    private Documento idDocumento;
    @JoinColumn(name = "id_exactitud", referencedColumnName = "id_exactitud")
    @ManyToOne
    private Exactitud idExactitud;

    //Relacion Mucho a Muchos
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "\"AMENAZA_TRANSACCION\"",
            joinColumns = { @JoinColumn(name = "id_transaccion") },
            inverseJoinColumns = { @JoinColumn(name = "id_amenaza") })
    private Collection<Amenaza> amenazaCollection;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "\"FACTORES_TRANSACCION\"",
            joinColumns = { @JoinColumn(name = "id_transaccion") },
            inverseJoinColumns = { @JoinColumn(name = "id_factores") })
    private Collection<FactoresInestabilidad> factoresCollection;

    @OneToMany(mappedBy = "idTransaccion")
    private Collection<Transicion> transicionCollection;

    public Transaccion() {
    }

    public Transaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Long getCalificacionCalculada() {
        return calificacionCalculada;
    }

    public void setCalificacionCalculada(Long calificacionCalculada) {
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

    public Collection<Transicion> getTransicionCollection() {
        return transicionCollection;
    }

    public void setTransicionCollection(Collection<Transicion> transicionCollection) {
        this.transicionCollection = transicionCollection;
    }

    public Collection<Amenaza> getAmenazaCollection() {
        return amenazaCollection;
    }

    public void setAmenazaCollection(Collection<Amenaza> amenazaCollection) {
        this.amenazaCollection = amenazaCollection;
    }

    public Collection<FactoresInestabilidad> getFactoresCollection() {
        return factoresCollection;
    }

    public void setFactoresCollection(Collection<FactoresInestabilidad> factoresCollection) {
        this.factoresCollection = factoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.hydrasearch.entities.Transaccion[ idTransaccion=" + idTransaccion + " ]";
    }
    
}
