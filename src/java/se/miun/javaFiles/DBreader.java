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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import se.miun.enities.Booking;

/**
 *
 * @author hassa
 */
@Named(value = "dBreader")
@Dependent
public class DBreader {
    private int index;
    List <Booking> resultList;

    @PersistenceContext(unitName = "Anton2PU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of DBreader
     */
    public DBreader() {
    }
    
    public int readerDB(){
        TypedQuery<Booking> MyQuery = em.createNamedQuery("Booking.findAll", Booking.class);
        resultList = MyQuery.getResultList();
        return indexFun(resultList);
    }
    
    public int indexFun(List <Booking> l){
        int lastId=0;
        for(int i = 0; i < l.size(); i++){
            if(l.get(i).getId() > lastId)
                lastId = l.get(i).getId();
        }
        return ++lastId;
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
