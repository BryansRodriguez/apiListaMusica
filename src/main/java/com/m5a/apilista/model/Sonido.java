/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.apilista.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "sonido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sonido.findAll", query = "SELECT s FROM Sonido s"),
    @NamedQuery(name = "Sonido.findByIdSonido", query = "SELECT s FROM Sonido s WHERE s.idSonido = :idSonido"),
    @NamedQuery(name = "Sonido.findByTitle", query = "SELECT s FROM Sonido s WHERE s.title = :title"),
    @NamedQuery(name = "Sonido.findByArtist", query = "SELECT s FROM Sonido s WHERE s.artist = :artist"),
    @NamedQuery(name = "Sonido.findByAlbum", query = "SELECT s FROM Sonido s WHERE s.album = :album"),
    @NamedQuery(name = "Sonido.findByYear", query = "SELECT s FROM Sonido s WHERE s.year = :year")})
public class Sonido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sonido")
    private Long idSonido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "artist")
    private String artist;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "album")
    private String album;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "year")
    private String year;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSonido")
    private List<Listas> listasList;

    public Sonido() {
    }

    public Sonido(Long idSonido) {
        this.idSonido = idSonido;
    }

    public Sonido(Long idSonido, String title, String artist, String album, String year, List<Listas> listasList) {
        this.idSonido = idSonido;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.listasList = listasList;
    }

    public Long getIdSonido() {
        return idSonido;
    }

    public void setIdSonido(Long idSonido) {
        this.idSonido = idSonido;
    }

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @XmlTransient
    public List<Listas> getListasList() {
        return listasList;
    }

    public void setListasList(List<Listas> listasList) {
        this.listasList = listasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSonido != null ? idSonido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sonido)) {
            return false;
        }
        Sonido other = (Sonido) object;
        if ((this.idSonido == null && other.idSonido != null) || (this.idSonido != null && !this.idSonido.equals(other.idSonido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.m5a.apilista.model.Sonido[ idSonido=" + idSonido + " ]";
    }
    
}
