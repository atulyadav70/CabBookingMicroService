package com.cbs.Ride.Service;

import com.cbs.Ride.Client.DriverClient;
import com.cbs.Ride.Client.UserClient;
import com.cbs.Ride.Dto.DriverDto;
import com.cbs.Ride.Dto.RideDto;
import com.cbs.Ride.Dto.UserDto;
import com.cbs.Ride.Entity.Rides;
import com.cbs.Ride.Repository.RideRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RideServiceImp implements IRideService{
    @Autowired
    RideRepository rideRepository;
    @Autowired
    UserClient userClient;
    @Autowired
    DriverClient driverClient;
    @Autowired
    ModelMapper modelMapper;




    @Override
    public Rides addRide(long userID, long driverId,String pickupLocation, String dropoffLocation) {
        UserDto user = userClient.getUserById(userID);
        DriverDto driver = driverClient.findDriverById(driverId);
        Rides ride = new Rides(userID , pickupLocation,dropoffLocation, LocalDateTime.now());
        ride.setUserFirstName(user.getFirstName());
        ride.setUserlastName(user.getLastName());
        ride.setDriverId(driver.getId());
        ride.setDriverFullname(driver.getFirstName(),driver.getLastName());
        ride.setActualFare(100);
        ride.setEndTime(LocalDateTime.now());
        return rideRepository.save(ride);

    }


    @Override
    public List<Rides> getUsersRides(long userId) {
        List<Rides> ridesDetails =  rideRepository.findByUserId(userId); // Returns List<Rides>
        return ridesDetails;
    }
}
