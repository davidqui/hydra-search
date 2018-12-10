/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Collection;
import java.util.Date;

;

/**
 *
 * @author aherreram
 */
public class TransaccionHistoricaDTO {

//    Campos Historial de Modificaciones
    private Long idHistorial;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaModificacion;
    private Usuario usuarioModifica;


//    Campos Transaccion
    private Long idTransaccion;
    private String descripcion;
    private Credibilidad idCredibilidad;
    private Exactitud idExactitud;

    private Collection <Amenaza> amenazaCollection;
    private Collection <FactoresInestabilidad> factoresCollection;

//    Campos Documento
    private Long idDocumento;
    private Boolean accesoPrivado;
    private Clasificacion idClasificacion;
    private TipoDoc idTipoDoc;


}
