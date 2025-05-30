package com.cbs.Ride.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 */
@Entity
@Table(name = "rides")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rides {


    public Rides(Long userId, String pickupLocation, String dropoffLocation, LocalDateTime startTime) {
        this.userId = userId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.startTime = startTime;

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private long driverId;

    private String userFirstName;
    private String userlastName;


    private String driverFullname;


    public String getDriverFullname() {
        return driverFullname;
    }
    public void setDriverFullname(String firstname , String lastnName) {
        String fullName = firstname + " " + lastnName;
        this.driverFullname = fullName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }


    public String getUserlastName() {
        return userlastName;
    }
    public void setUserlastName(String userlastName) {
        this.userlastName = userlastName;
    }

    @Column(nullable = false)
    private String pickupLocation;

    @Column(nullable = false)
    private String dropoffLocation;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private float actualFare;

    public Long getDriverId() {
        return driverId;
    }
    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }
    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }
    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public float getActualFare() {
        return actualFare;
    }
    public void setActualFare(float actualFare) {
        this.actualFare = actualFare;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }






}
