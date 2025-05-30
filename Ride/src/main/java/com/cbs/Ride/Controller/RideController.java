package com.cbs.Ride.Controller;

import com.cbs.Ride.Dto.RideDto;
import com.cbs.Ride.Entity.Rides;
import com.cbs.Ride.Service.IRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rides")
public class RideController {
    @Autowired
    IRideService rideService;

    @PostMapping
    public ResponseEntity<Rides> createRide (@RequestParam long userID, @RequestParam long driverId,  @RequestParam String pickupLocation, @RequestParam String dropoffLocation){
        return new ResponseEntity<Rides>(rideService.addRide(userID,driverId, pickupLocation,dropoffLocation), HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<List<Rides>> getUsersRides(@PathVariable long id){
        return new ResponseEntity<List<Rides>>(rideService.getUsersRides(id),HttpStatus.OK);
    }
}
