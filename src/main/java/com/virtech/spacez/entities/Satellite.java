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
@Table(name = "satellite")
public class Satellite {

    // table columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "direction_clockwise")
    private Boolean directionClockwise;

    @Column(name = "fov")
    private Integer fov;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "satellite_orbit_id")
    private SatelliteOrbit satelliteOrbit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsDirectionClockwise() {
        return directionClockwise;
    }

    public void setIsDirectionClockwise(Boolean directionClockwise) {
        this.directionClockwise = directionClockwise;
    }

    public Integer getFov() {
        return fov;
    }

    public void setFov(Integer fov) {
        this.fov = fov;
    }

    public SatelliteOrbit getSatelliteOrbit() {
        return satelliteOrbit;
    }

    public void setSatelliteOrbit(SatelliteOrbit satelliteOrbit) {
        this.satelliteOrbit = satelliteOrbit;
    }
}