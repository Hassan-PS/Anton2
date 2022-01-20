/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.miun.enities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hassa
 */
@Entity
@Table(name = "LUNCHMENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lunchmenu.findAll", query = "SELECT l FROM Lunchmenu l"),
    @NamedQuery(name = "Lunchmenu.findById", query = "SELECT l FROM Lunchmenu l WHERE l.id = :id"),
    @NamedQuery(name = "Lunchmenu.findByLunchName", query = "SELECT l FROM Lunchmenu l WHERE l.lunchName = :lunchName"),
    @NamedQuery(name = "Lunchmenu.findByDescription", query = "SELECT l FROM Lunchmenu l WHERE l.description = :description"),
    @NamedQuery(name = "Lunchmenu.findByLunchDate", query = "SELECT l FROM Lunchmenu l WHERE l.lunchDate = :lunchDate")})
public class Lunchmenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "LUNCH_NAME")
    private String lunchName;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "LUNCH_DATE")
    @Temporal(TemporalType.DATE)
    private Date lunchDate;

    public Lunchmenu() {
    }

    public Lunchmenu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLunchName() {
        return lunchName;
    }

    public void setLunchName(String lunchName) {
        this.lunchName = lunchName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLunchDate() {
        return lunchDate;
    }

    public void setLunchDate(Date lunchDate) {
        this.lunchDate = lunchDate;
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
        if (!(object instanceof Lunchmenu)) {
            return false;
        }
        Lunchmenu other = (Lunchmenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.miun.enities.Lunchmenu[ id=" + id + " ]";
    }
    
}
