/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.miun.javaFiles;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.miun.enities.Booking;

/**
 *
 * @author hassa
 */
@ManagedBean
@RequestScoped
public class DBsender {
    private String date;    //ess
    private String email;   //ess
    private int guestNr;    //ess
    private int id;         //ess
    private String name;    //ess
    private int pass;       //ess
    private String phoneNr; //ess
    private int tableNr;    //ess
    
    @PersistenceContext(unitName = "Anton2PU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    public void writerDB(int index){
        Booking newBooking = new Booking();
        
        newBooking.setName(name);
        newBooking.setEmail(email);
        newBooking.setPhonenr(phoneNr);
        id = index;
        newBooking.setId(id);
        newBooking.setPass(pass);
        newBooking.setDate(date);
        newBooking.setGuestnr(guestNr);
        newBooking.setTablenr(tableNr);
        
        if(name != null || date != null || email != null || guestNr != 0 || pass != 0 || phoneNr != null || tableNr != 0)
            persist(newBooking);
    }

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the guestNr
     */
    public int getGuestNr() {
        return guestNr;
    }

    /**
     * @param guestNr the guestNr to set
     */
    public void setGuestNr(int guestNr) {
        this.guestNr = guestNr;
    }


    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pass
     */
    public int getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(int pass) {
        this.pass = pass;
    }


    /**
     * @return the phoneNr
     */
    public String getPhoneNr() {
        return phoneNr;
    }

    /**
     * @param phoneNr the phoneNr to set
     */
    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    /**
     * @return the tableNr
     */
    public int getTableNr() {
        return tableNr;
    }

    /**
     * @param tableNr the tableNr to set
     */
    public void setTableNr(int tableNr) {
        this.tableNr = tableNr;
    }

    
    
    
}
