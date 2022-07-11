/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.apilista.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "listas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listas.findAll", query = "SELECT l FROM Listas l"),
    @NamedQuery(name = "Listas.findByIdLista", query = "SELECT l FROM Listas l WHERE l.idLista = :idLista"),
    @NamedQuery(name = "Listas.findByName", query = "SELECT l FROM Listas l WHERE l.name = :name"),
    @NamedQuery(name = "Listas.findByDescription", query = "SELECT l FROM Listas l WHERE l.description = :description")})
public class Listas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lista")
    private Long idLista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "id_sonido", referencedColumnName = "id_sonido")
    @ManyToOne(optional = false)
    private Sonido idSonido;

    public Listas() {
    }

    public Listas(Long idLista) {
        this.idLista = idLista;
    }

    public Listas(Long idLista, String name, String description, Sonido idSonido) {
        this.idLista = idLista;
        this.name = name;
        this.description = description;
        this.idSonido = idSonido;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sonido getIdSonido() {
        return idSonido;
    }

    public void setIdSonido(Sonido idSonido) {
        this.idSonido = idSonido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLista != null ? idLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listas)) {
            return false;
        }
        Listas other = (Listas) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.m5a.apilista.model.Listas[ idLista=" + idLista + " ]";
    }
    
}
