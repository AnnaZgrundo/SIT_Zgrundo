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
 * @author Игорь
 */
@Entity
@Table(name = "producer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producer.findAll", query = "SELECT p FROM Producer p"),
    @NamedQuery(name = "Producer.findByIdP", query = "SELECT p FROM Producer p WHERE p.idP = :idP"),
    @NamedQuery(name = "Producer.findByName", query = "SELECT p FROM Producer p WHERE p.name = :name"),
    @NamedQuery(name = "Producer.findByYear", query = "SELECT p FROM Producer p WHERE p.year = :year")})
public class Producer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idP")
    private Integer idP;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private Integer year;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idP")
    private Collection<Award> awardCollection;

    public Producer() {
    }

    public Producer(Integer idP) {
        this.idP = idP;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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
        hash += (idP != null ? idP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producer)) {
            return false;
        }
        Producer other = (Producer) object;
        if ((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.lab5.bean.Producer[ idP=" + idP + " ]";
    }
    
}
