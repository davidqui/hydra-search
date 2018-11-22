/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "\"USUARIO\"")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "id_ldap")
    private BigInteger idLdap;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nivel_clasificacion")
    private String nivelClasificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginUsuario")
    private Collection<Transicion> transicionCollection;
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad")
    @ManyToOne(optional = false)
    private Unidad idUnidad;

    public Usuario() {
    }

    public Usuario(String login) {
        this.login = login;
    }

    public Usuario(String login, String nivelClasificacion) {
        this.login = login;
        this.nivelClasificacion = nivelClasificacion;
    }

    public BigInteger getIdLdap() {
        return idLdap;
    }

    public void setIdLdap(BigInteger idLdap) {
        this.idLdap = idLdap;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNivelClasificacion() {
        return nivelClasificacion;
    }

    public void setNivelClasificacion(String nivelClasificacion) {
        this.nivelClasificacion = nivelClasificacion;
    }

    public Collection<Transicion> getTransicionCollection() {
        return transicionCollection;
    }

    public void setTransicionCollection(Collection<Transicion> transicionCollection) {
        this.transicionCollection = transicionCollection;
    }

    public Unidad getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Unidad idUnidad) {
        this.idUnidad = idUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idLdap);
        hash = 79 * hash + Objects.hashCode(this.login);
        hash = 79 * hash + Objects.hashCode(this.nivelClasificacion);
        hash = 79 * hash + Objects.hashCode(this.transicionCollection);
        hash = 79 * hash + Objects.hashCode(this.idUnidad);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.nivelClasificacion, other.nivelClasificacion)) {
            return false;
        }
        if (!Objects.equals(this.idLdap, other.idLdap)) {
            return false;
        }
        if (!Objects.equals(this.transicionCollection, other.transicionCollection)) {
            return false;
        }
        if (!Objects.equals(this.idUnidad, other.idUnidad)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idLdap=" + idLdap + ", login=" + login + ", nivelClasificacion=" + nivelClasificacion + ", idUnidad=" + idUnidad + '}';
    }

}
