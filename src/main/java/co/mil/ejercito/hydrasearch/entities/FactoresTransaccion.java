/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author aherreram
 */
@Entity
@Table(name = "\"FACTORES_TRANSACCION\"")
@NamedQueries({
    @NamedQuery(name = "FactoresTransaccion.findAll", query = "SELECT f FROM FactoresTransaccion f")})
public class FactoresTransaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_transaccion")
    private Long idTransaccion;
    @JoinColumn(name = "id_factores", referencedColumnName = "id_factores")
    @ManyToOne(optional = false)
    private FactoresInestabilidad idFactores;
    @JoinColumn(name = "id_transaccion", referencedColumnName = "id_transaccion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Transaccion transaccion;

    public FactoresTransaccion() {
    }

    public FactoresTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public FactoresInestabilidad getIdFactores() {
        return idFactores;
    }

    public void setIdFactores(FactoresInestabilidad idFactores) {
        this.idFactores = idFactores;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
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
        if (!(object instanceof FactoresTransaccion)) {
            return false;
        }
        FactoresTransaccion other = (FactoresTransaccion) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.hydrasearch.entities.FactoresTransaccion[ idTransaccion=" + idTransaccion + " ]";
    }
    
}
