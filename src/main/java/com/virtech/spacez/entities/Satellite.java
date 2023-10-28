package com.virtech.spacez.entities;

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

@Entity
@Table(name = "satellite")
public class Satellite {

    // table columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "direction_clockwise")
    private boolean directionClockwise;

    @Column(name = "fov")
    private int fov;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "satellite_orbit_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SatelliteOrbit satelliteOrbit;

    // getters/setters
    public int getId() {
        return id;
    }
    
    public boolean getDirectionClockwise() {
        return directionClockwise;
    }

    public void setDirectionClockwise(boolean directionClockwise) {
        this.directionClockwise = directionClockwise;
    }

    public int getFov() {
        return fov;
    }

    public void setFov(int fov) {
        this.fov = fov;
    }

    public SatelliteOrbit getSatelliteOrbit() {
        return satelliteOrbit;
    }

    public void setSatelliteOrbit(SatelliteOrbit satelliteOrbit) {
        this.satelliteOrbit = satelliteOrbit;
    }
}