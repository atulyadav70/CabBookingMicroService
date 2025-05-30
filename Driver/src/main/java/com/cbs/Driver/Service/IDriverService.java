package com.cbs.Driver.Service;

import com.cbs.Driver.dto.DriverLoginDto;
import com.cbs.Driver.dto.DriverProfileDto;
import com.cbs.Driver.dto.DriverRegistrationDto;

public interface IDriverService {

    DriverRegistrationDto registerDriver(DriverRegistrationDto driverRegistrationDto);
    DriverProfileDto getDriverById (Long id);
    String  driverLogin(DriverLoginDto driverLoginDto);
}
