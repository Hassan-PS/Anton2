/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.miun.enities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hassa
 */
@Entity
@Table(name = "KITCHENAPP2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kitchenapp2.findAll", query = "SELECT k FROM Kitchenapp2 k"),
    @NamedQuery(name = "Kitchenapp2.findByFoodname", query = "SELECT k FROM Kitchenapp2 k WHERE k.foodname = :foodname"),
    @NamedQuery(name = "Kitchenapp2.findById", query = "SELECT k FROM Kitchenapp2 k WHERE k.id = :id"),
    @NamedQuery(name = "Kitchenapp2.findByNotes", query = "SELECT k FROM Kitchenapp2 k WHERE k.notes = :notes"),
    @NamedQuery(name = "Kitchenapp2.findByTablenr", query = "SELECT k FROM Kitchenapp2 k WHERE k.tablenr = :tablenr"),
    @NamedQuery(name = "Kitchenapp2.findByTime", query = "SELECT k FROM Kitchenapp2 k WHERE k.time = :time"),
    @NamedQuery(name = "Kitchenapp2.findByTimestamp", query = "SELECT k FROM Kitchenapp2 k WHERE k.timestamp = :timestamp"),
    @NamedQuery(name = "Kitchenapp2.findByFoodtype", query = "SELECT k FROM Kitchenapp2 k WHERE k.foodtype = :foodtype"),
    @NamedQuery(name = "Kitchenapp2.findByKitchenid", query = "SELECT k FROM Kitchenapp2 k WHERE k.kitchenid = :kitchenid"),
    @NamedQuery(name = "Kitchenapp2.findByDone", query = "SELECT k FROM Kitchenapp2 k WHERE k.done = :done"),
    @NamedQuery(name = "Kitchenapp2.findByDelivered", query = "SELECT k FROM Kitchenapp2 k WHERE k.delivered = :delivered")})
public class Kitchenapp2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "FOODNAME")
    private String foodname;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Size(max = 500)
    @Column(name = "NOTES")
    private String notes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TABLENR")
    private int tablenr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIME")
    private String time;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIMESTAMP")
    private String timestamp;
    @Column(name = "FOODTYPE")
    private Integer foodtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KITCHENID")
    private int kitchenid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DONE")
    private Boolean done;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERED")
    private Boolean delivered;

    public Kitchenapp2() {
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getTablenr() {
        return tablenr;
    }

    public void setTablenr(int tablenr) {
        this.tablenr = tablenr;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(Integer foodtype) {
        this.foodtype = foodtype;
    }

    public int getKitchenid() {
        return kitchenid;
    }

    public void setKitchenid(int kitchenid) {
        this.kitchenid = kitchenid;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }
    
}
