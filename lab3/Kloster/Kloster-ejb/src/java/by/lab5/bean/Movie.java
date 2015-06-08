/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.lab5.bean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Игорь
 */
@Entity
@Table(name = "movie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByIdM", query = "SELECT m FROM Movie m WHERE m.idM = :idM"),
    @NamedQuery(name = "Movie.findByDescriprion", query = "SELECT m FROM Movie m WHERE m.descriprion = :descriprion")})
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idM")
    private Integer idM;
    @Size(max = 45)
    @Column(name = "descriprion")
    private String descriprion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idM")
    private Collection<Award> awardCollection;

    public Movie() {
    }

    public Movie(Integer idM) {
        this.idM = idM;
    }

    public Integer getIdM() {
        return idM;
    }

    public void setIdM(Integer idM) {
        this.idM = idM;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    @XmlTransient
    public Collection<Award> getAwardCollection() {
        return awardCollection;
    }

    public void setAwardCollection(Collection<Award> awardCollection) {
        this.awardCollection = awardCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idM != null ? idM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.idM == null && other.idM != null) || (this.idM != null && !this.idM.equals(other.idM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.lab5.bean.Movie[ idM=" + idM + " ]";
    }
    
}
