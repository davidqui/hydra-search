/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
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
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nivel_clasificacion")
    private String nivelClasificacion;
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad")
    @ManyToOne(optional = false)
    private Unidad idUnidad;
    @JsonIgnore
    @OneToMany(mappedBy = "loginUsuario")
    private Collection<Transicion> transicionCollection;

    public Usuario() {
    }

    public Usuario(String login) {
        this.login = login;
    }

    public Usuario(String login, String nombre, String nivelClasificacion) {
        this.login = login;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelClasificacion() {
        return nivelClasificacion;
    }

    public void setNivelClasificacion(String nivelClasificacion) {
        this.nivelClasificacion = nivelClasificacion;
    }

    public Unidad getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Unidad idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Collection<Transicion> getTransicionCollection() {
        return transicionCollection;
    }

    public void setTransicionCollection(Collection<Transicion> transicionCollection) {
        this.transicionCollection = transicionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.hydrasearch.entities.Usuario[ login=" + login + " ]";
    }
    
}
