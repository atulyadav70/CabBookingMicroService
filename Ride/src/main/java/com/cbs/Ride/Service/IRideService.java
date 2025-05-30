package com.cbs.Ride.Service;

import com.cbs.Ride.Dto.RideDto;
import com.cbs.Ride.Entity.Rides;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IRideService {
    Rides addRide(long userID, long driverid, String pickupLocation, String dropoffLocation);
    List<Rides> getUsersRides(long userId);
}
