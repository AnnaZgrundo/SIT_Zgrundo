/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.lab5.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Игорь
 */
@Entity
@Table(name = "award")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Award.findAll", query = "SELECT a FROM Award a"),
    @NamedQuery(name = "Award.findByIdA", query = "SELECT a FROM Award a WHERE a.idA = :idA"),
    @NamedQuery(name = "Award.findByTitle", query = "SELECT a FROM Award a WHERE a.title = :title")})
public class Award implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idA")
    private Integer idA;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @JoinColumn(name = "idP", referencedColumnName = "idP")
    @ManyToOne(optional = false)
    private Producer idP;
    @JoinColumn(name = "idM", referencedColumnName = "idM")
    @ManyToOne(optional = false)
    private Movie idM;

    public Award() {
    }

    public Award(Integer idA) {
        this.idA = idA;
    }

    public Integer getIdA() {
        return idA;
    }

    public void setIdA(Integer idA) {
        this.idA = idA;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Producer getIdP() {
        return idP;
    }

    public void setIdP(Producer idP) {
        this.idP = idP;
    }

    public Movie getIdM() {
        return idM;
    }

    public void setIdM(Movie idM) {
        this.idM = idM;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idA != null ? idA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Award)) {
            return false;
        }
        Award other = (Award) object;
        if ((this.idA == null && other.idA != null) || (this.idA != null && !this.idA.equals(other.idA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.lab5.bean.Award[ idA=" + idA + " ]";
    }
    
}
