package com.virtech.spacez.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "satellite_orbit")
public class SatelliteOrbit {
    
    // table columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "horizontal_angle")
    private Double horizontalAngle;

    @Column(name = "vertical_angle")
    private Double verticalAngle;

    @Column(name = "semi_major_axis")
    private Double semiMajorAxis;

    @Column(name = "semi_minor_axis")
    private Double semiMinorAxis;

    // constructors
    public SatelliteOrbit() {}

    public SatelliteOrbit(Double horizontalAngle, Double verticalAngle, Double semiMajorAxis, Double semiMinorAxis) {
        this.horizontalAngle = horizontalAngle;
        this.verticalAngle = verticalAngle;
        this.semiMajorAxis = semiMajorAxis;
        this.semiMinorAxis = semiMinorAxis;
    }

    // getters/setters

    public Double getHorizontalAngle() {
        return horizontalAngle;
    }

    public void setHorizontalAngle(Double horizontalAngle) {
        this.horizontalAngle = horizontalAngle;
    }

    public Double getVerticalAngle() {
        return verticalAngle;
    }

    public void setVerticalAngle(Double verticalAngle) {
        this.verticalAngle = verticalAngle;
    }

    public Double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(Double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public Double getSemiMinorAxis() {
        return semiMinorAxis;
    }

    public void setSemiMinorAxis(Double semiMinorAxis) {
        this.semiMinorAxis = semiMinorAxis;
    }
}