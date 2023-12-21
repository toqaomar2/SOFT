package com.app.order;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "ORDERTABLE")
public class orderDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CUSTOMERID")
    private int customerId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="ORDERDATE")
    private Date orderDate;

    private int TOTALPRICE;


    @Column(name="CONFBYADMIN")
    private String confAdmin;

    @Column(name="POPUPUSER")
    private String popUpUser;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getTOTALPRICE() {
        return TOTALPRICE;
    }

    public void setTOTALPRICE(int TOTALPRICE) {
        this.TOTALPRICE = TOTALPRICE;
    }

    public String getConfAdmin() {
        return confAdmin;
    }

    public void setConfAdmin(String confAdmin) {
        this.confAdmin = confAdmin;
    }

    public String getPopUpUser() {
        return popUpUser;
    }

    public void setPopUpUser(String popUpUser) {
        this.popUpUser = popUpUser;
    }
}
