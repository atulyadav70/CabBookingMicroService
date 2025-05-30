package com.cbs.Driver.Controller;

import com.cbs.Driver.Service.IDriverService;
import com.cbs.Driver.dto.DriverLoginDto;
import com.cbs.Driver.dto.DriverProfileDto;
import com.cbs.Driver.dto.DriverRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {
    @Autowired
    IDriverService driverService;

    @PostMapping("/register")
    ResponseEntity<DriverRegistrationDto> addDriver(@RequestBody DriverRegistrationDto driverRegistrationDto){
        return new ResponseEntity<DriverRegistrationDto>(driverService.registerDriver(driverRegistrationDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    ResponseEntity<DriverProfileDto> findDriverById(@PathVariable long id){
        return new ResponseEntity<DriverProfileDto>(driverService.getDriverById(id),HttpStatus.OK);
    }
    @PostMapping ("/login")
    ResponseEntity<String> driverLogin(@RequestBody DriverLoginDto driverLoginDto){
        return new ResponseEntity<String>(driverService.driverLogin(driverLoginDto),HttpStatus.OK);
    }


}
