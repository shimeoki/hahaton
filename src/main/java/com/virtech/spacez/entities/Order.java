package com.virtech.spacez.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "order")
public class Order {
    
    // table columns

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "satellite_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Satellite satellite;

    @Column(name = "order_datetime", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDatetime;

    @Column(name = "shot_datetime", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shotDatetime;

    // getters / setters

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Satellite getSatellite() {
        return satellite;
    }

    public void setSatellite(Satellite satellite) {
        this.satellite = satellite;
    }

    public Date getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Date orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public Date getShotDatetime() {
        return shotDatetime;
    }

    public void setShotDatetime(Date shotDatetime) {
        this.shotDatetime = shotDatetime;
    }
}