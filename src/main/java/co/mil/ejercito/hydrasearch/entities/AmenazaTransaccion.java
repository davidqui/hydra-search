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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author aherreram
 */
@Entity
@Table(name = "\"AMENAZA_TRANSACCION\"")
@NamedQueries({
    @NamedQuery(name = "AmenazaTransaccion.findAll", query = "SELECT a FROM AmenazaTransaccion a")})
public class AmenazaTransaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_amenaza", referencedColumnName = "id_amenaza")
    @ManyToOne(optional = false)
    private Amenaza idAmenaza;
    @JoinColumn(name = "id_transaccion", referencedColumnName = "id_transaccion")
    @ManyToOne(optional = false)
    private Transaccion idTransaccion;

    public AmenazaTransaccion() {
    }

    public AmenazaTransaccion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Amenaza getIdAmenaza() {
        return idAmenaza;
    }

    public void setIdAmenaza(Amenaza idAmenaza) {
        this.idAmenaza = idAmenaza;
    }

    public Transaccion getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Transaccion idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmenazaTransaccion)) {
            return false;
        }
        AmenazaTransaccion other = (AmenazaTransaccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AmenazaTransaccion{" + "id=" + id + '}';
    }

}
