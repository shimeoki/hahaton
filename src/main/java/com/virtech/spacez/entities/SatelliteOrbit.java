package com.virtech.spacez.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "satellite_orbit")
public class SatelliteOrbit {
    
    // table columns

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "horizontal_angle")
    private double horizontalAngle;

    @Column(name = "vertical_angle")
    private double verticalAngle;

    @Column(name = "semi_major_axis")
    private double semiMajorAxis;

    @Column(name = "semi_minor_axis")
    private double semiMinorAxis;

    // getters/setters
    
    public int getId() {
        return id;
    }
    
    public double getHorizontalAngle() {
        return horizontalAngle;
    }

    public void setHorizontalAngle(double horizontalAngle) {
        this.horizontalAngle = horizontalAngle;
    }

    public double getVerticalAngle() {
        return verticalAngle;
    }

    public void setVerticalAngle(double verticalAngle) {
        this.verticalAngle = verticalAngle;
    }

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }

    public void setSemiMinorAxis(double semiMinorAxis) {
        this.semiMinorAxis = semiMinorAxis;
    }
}