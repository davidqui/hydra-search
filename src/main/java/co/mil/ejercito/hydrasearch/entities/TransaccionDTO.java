/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

;

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
    private Long idCredibilidad;
    private Long idExactitud;
    private Amenaza amenazaCollection;
    private FactoresInestabilidad factoresCollection;

//    Campos Trasicion
    private String estado;
    private Boolean activo;
    private String loginUsuario;
    
//    Campos Documento
    private Long idDocumento;
    private String nombreDoc;
    private String urlDocumento;
    private Boolean accesoPrivado;
    private Long idClasificacion;
    private Long idTipoDoc;

    public TransaccionDTO() {
    }

    public TransaccionDTO(Long idTransaccion, Date fechaTransaccion, Long calificacionCalculada, String descripcion, Long idCredibilidad, Long idExactitud, Amenaza amenazaCollection, FactoresInestabilidad factoresCollection, String estado, Boolean activo, String loginUsuario, Long idDocumento, String nombreDoc, String urlDocumento, Boolean accesoPrivado, Long idClasificacion, Long idTipoDoc) {
        this.idTransaccion = idTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.calificacionCalculada = calificacionCalculada;
        this.descripcion = descripcion;
        this.idCredibilidad = idCredibilidad;
        this.idExactitud = idExactitud;
        this.amenazaCollection = amenazaCollection;
        this.factoresCollection = factoresCollection;
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

    public Long getIdCredibilidad() {
        return idCredibilidad;
    }

    public void setIdCredibilidad(Long idCredibilidad) {
        this.idCredibilidad = idCredibilidad;
    }

    public Long getIdExactitud() {
        return idExactitud;
    }

    public void setIdExactitud(Long idExactitud) {
        this.idExactitud = idExactitud;
    }

//    public Collection<Amenaza> getAmenazaCollection() {
//        return amenazaCollection;
//    }

//    public void setAmenazaCollection(Collection<Amenaza> amenazaCollection) {
//        this.amenazaCollection = amenazaCollection;
//    }

//    public Collection<FactoresInestabilidad> getFactoresCollection() {
//        return factoresCollection;
//    }
//
//    public void setFactoresCollection(Collection<FactoresInestabilidad> factoresCollection) {
//        this.factoresCollection = factoresCollection;
//    }


    public Amenaza getAmenazaCollection() {
        return amenazaCollection;
    }

    public void setAmenazaCollection(Amenaza amenazaCollection) {
        this.amenazaCollection = amenazaCollection;
    }

    public FactoresInestabilidad getFactoresCollection() {
        return factoresCollection;
    }

    public void setFactoresCollection(FactoresInestabilidad factoresCollection) {
        this.factoresCollection = factoresCollection;
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

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
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

    public Long getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Long idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public Long getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(Long idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }
}
