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
@ManagedBean(name="bookingSender")
@RequestScoped
public class BookingSender{
    private String date;    //ess
    private String email;   //ess
    private int guestNr;    //ess
    private String guestNrS;
    private int id;         //ess
    private String name;    //ess
    private int pass;       //ess
    private String passS;
    private String phoneNr; //ess
    private int tableNr;    //ess
    private String tableNrS;
    
    @PersistenceContext(unitName = "Anton2PU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    
    
    public void send(){
        Booking newBooking = new Booking();
        newBooking.setName("Hassan");
        newBooking.setDate("HelloWorld");
        newBooking.setEmail("HelloWorld");
        newBooking.setPhonenr("HelloWorld");
        newBooking.setTablenr(1);
        newBooking.setGuestnr(2);
       //newBooking.setId(index);

        if ("Bokningstid".equals(passS))
            setPass(0);
        if ("Breakfast".equals(passS))
            setPass(1);
        if ("Lunch".equals(passS))
            setPass(2);
        if ("Dinner".equals(passS))
            setPass(3);
        newBooking.setPass(pass);
        
        persist(newBooking);
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
    
    public void setGuestNrS(String guestNrS) {
        this.guestNrS = guestNrS;
    }
    
    public String getGuestNrS() {
        return guestNrS;
    }
    
    public void setTableNrS(String tableNrS) {
        this.tableNrS = tableNrS;
    }
    
    public String getTableNrS() {
        return tableNrS;
    }
    
    public void setPassS(String passS) {
        this.passS = passS;
    }
    
    public String getPassS() {
        return passS;
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
    
    /*@WebServlet("/reservationServlet")
    public class ReservationServlet extends HttpServlet{
        @Override
        protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
            setName(request.getParameter("name"));
            setEmail(request.getParameter("email"));
            setPhoneNr(request.getParameter("phone"));
            setGuestNr(Integer.valueOf(request.getParameter("number-guests")));
            setTableNr(Integer.valueOf(request.getParameter("number-table")));
            setDate((request.getParameter("date")));
            String tid = request.getParameter("time");
            if (tid == "Bokningstid")
                setPass(0);
            if (tid == "Breakfast")
                setPass(1);
            if (tid == "Lunch")
                setPass(2);
            if (tid == "Dinner")
                setPass(3);
            prepareSend();
            send();
        }
    }*/
}
