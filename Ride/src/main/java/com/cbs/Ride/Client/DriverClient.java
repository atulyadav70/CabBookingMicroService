package com.cbs.Ride.Client;

import com.cbs.Ride.Dto.DriverDto;
import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "DRIVER")
public interface DriverClient {
    @GetMapping("/api/v1/driver/{id}")
    DriverDto findDriverById(@PathVariable long id);
}
