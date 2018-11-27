/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author aherreram
 */
@Entity
public class TransaccionDTO {
    
    
//    Campos Transaccion
    @Id
    private Long idTransaccion;
    private Date fechaTransaccion;
    private Long calificacionCalculada;
    private String descripcion;
    private Credibilidad idCredibilidad;
    private Exactitud idExactitud;
//    private Collection<AmenazaTransaccion> amenazaTransaccionCollection;
//    private Collection<FactoresTransaccion> factoresTransaccionCollection;
    
//    Campos Trasicion
    private String estado;
    private Boolean activo;
    private Usuario loginUsuario;
    
//    Campos Documento
    private Long idDocumento;
    private String nombreDoc;
    private String urlDocumento;
    private Boolean accesoPrivado;
    private Clasificacion idClasificacion;
    private TipoDoc idTipoDoc;

    public TransaccionDTO() {
    }

    public TransaccionDTO(Long idTransaccion, Date fechaTransaccion, Long calificacionCalculada, String descripcion, Credibilidad idCredibilidad, Exactitud idExactitud, String estado, Boolean activo, Usuario loginUsuario, Long idDocumento, String nombreDoc, String urlDocumento, Boolean accesoPrivado, Clasificacion idClasificacion, TipoDoc idTipoDoc) {
        this.idTransaccion = idTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.calificacionCalculada = calificacionCalculada;
        this.descripcion = descripcion;
        this.idCredibilidad = idCredibilidad;
        this.idExactitud = idExactitud;
        this.estado = estado;
        this.activo = activo;
        this.loginUsuario = loginUsuario;
        this.idDocumento = idDocumento;
        this.nombreDoc = nombreDoc;
        this.urlDocumento = urlDocumento;
        this.accesoPrivado = accesoPrivado;
        this.idClasificacion = idClasificacion;
        this.idTipoDoc = idTipoDoc;
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

    public Credibilidad getIdCredibilidad() {
        return idCredibilidad;
    }

    public void setIdCredibilidad(Credibilidad idCredibilidad) {
        this.idCredibilidad = idCredibilidad;
    }

    public Exactitud getIdExactitud() {
        return idExactitud;
    }

    public void setIdExactitud(Exactitud idExactitud) {
        this.idExactitud = idExactitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Usuario getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(Usuario loginUsuario) {
        this.loginUsuario = loginUsuario;
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

    public Boolean getAccesoPrivado() {
        return accesoPrivado;
    }

    public void setAccesoPrivado(Boolean accesoPrivado) {
        this.accesoPrivado = accesoPrivado;
    }

    public Clasificacion getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Clasificacion idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public TipoDoc getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(TipoDoc idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    
    
}
