/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sparksonet
 */
@Entity
@Table(name = "new_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewView.findAll", query = "SELECT n FROM NewView n"),
    @NamedQuery(name = "NewView.findByRegion", query = "SELECT n FROM NewView n WHERE n.region = :region"),
    @NamedQuery(name = "NewView.findByCirculation", query = "SELECT n FROM NewView n WHERE n.circulation = :circulation")})
public class NewView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "region")
    @Id
    private String region;
    @Column(name = "circulation")
    private BigInteger circulation;

    public NewView() {
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigInteger getCirculation() {
        return circulation;
    }

    public void setCirculation(BigInteger circulation) {
        this.circulation = circulation;
    }
    
}
