/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Bachilo
 */
@Entity
@Table(name = "News")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findByIdNews", query = "SELECT n FROM News n WHERE n.idNews = :idNews"),
    @NamedQuery(name = "News.findByName", query = "SELECT n FROM News n WHERE n.name = :name"),
    @NamedQuery(name = "News.findByCirculation", query = "SELECT n FROM News n WHERE n.circulation = :circulation"),
    @NamedQuery(name = "News.findByPublishdate", query = "SELECT n FROM News n WHERE n.publishdate = :publishdate"),
    @NamedQuery(name = "News.findByRegion", query = "SELECT n FROM News n WHERE n.region = :region")})
public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNews")
    @Expose
    private Integer idNews;
    @Size(max = 45)
    @Column(name = "name")
    @Expose
    private String name;
    @Column(name = "circulation")
    @Expose
    private Integer circulation;
    @Column(name = "publishdate")
    @Temporal(TemporalType.DATE)
    @Expose
    private Date publishdate;
    @Size(max = 45)
    @Column(name = "region")
    @Expose
    private String region;
    @JoinColumn(name = "authorName", referencedColumnName = "authorName")
    @ManyToOne(optional = false)
    @Expose
    private Author authorName;

    public News() {
    }

    public News(Integer idNews) {
        this.idNews = idNews;
    }

    public Integer getIdNews() {
        return idNews;
    }

    public void setIdNews(Integer idNews) {
        this.idNews = idNews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCirculation() {
        return circulation;
    }

    public void setCirculation(Integer circulation) {
        this.circulation = circulation;
    }

    public String getPublishdate() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(publishdate);
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Author getAuthorName() {
        return authorName;
    }

    public void setAuthorName(Author authorName) {
        this.authorName = authorName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNews != null ? idNews.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.idNews == null && other.idNews != null) || (this.idNews != null && !this.idNews.equals(other.idNews))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.News[ idNews=" + idNews + " ]";
    }

}
