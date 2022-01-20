/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package se.miun.javaFiles;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import se.miun.enities.Booking;

/**
 *
 * @author hassa
 */
@Named(value = "myDBfun")
@Dependent

@ManagedBean
@RequestScoped
public class MyDBfun {
    private int index;
    @PersistenceContext(unitName = "Anton2PU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of MyDBfun
     */
    public MyDBfun() {
    }
 
    
    public int indexFun(List <Booking> l){
        int lastId=0;
        for(int i = 0; i < l.size(); i++){
            if(l.get(i).getId() > lastId)
                lastId = l.get(i).getId();
        }
        return ++lastId;
    }
    
    public void readerDB(){
        TypedQuery<Booking> MyQuery = em.createNamedQuery("Booking.findAll", Booking.class);
        List <Booking> resultList = MyQuery.getResultList();
        int lastId=0;
        for(int i = 0; i < resultList.size(); i++){
            if(resultList.get(i).getId() > lastId)
                lastId = resultList.get(i).getId();
                setIndex(++lastId);
        }
        lastId=0;
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
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }
    
}
