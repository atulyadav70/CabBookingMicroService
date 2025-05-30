package com.cbs.Driver.Service;

import com.cbs.Driver.DriverApplication;
import com.cbs.Driver.Entity.Driver;
import com.cbs.Driver.Repository.IDriverRepository;
import com.cbs.Driver.dto.DriverLoginDto;
import com.cbs.Driver.dto.DriverProfileDto;
import com.cbs.Driver.dto.DriverRegistrationDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DriverServiceImpl implements IDriverService{
    @Autowired
    IDriverRepository driverRepository;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public DriverRegistrationDto registerDriver(DriverRegistrationDto driverRegistrationDto) {
        Driver mappedDriver = modelMapper.map(driverRegistrationDto, Driver.class);
        mappedDriver.setRegistrationDate(LocalDateTime.now());
        Driver savedDriver = driverRepository.save(mappedDriver);
        DriverRegistrationDto savedDriverDto = modelMapper.map(savedDriver, DriverRegistrationDto.class);
        return savedDriverDto;
    }

    @Override
    public DriverProfileDto getDriverById(Long id) {
        Optional<Driver> driver = driverRepository.findById(id);
        DriverProfileDto driverProfile = modelMapper.map(driver.get(),DriverProfileDto.class);
        return driverProfile;

    }

    @Override
    public String driverLogin(DriverLoginDto driverLoginDto) {
        Driver driver = driverRepository.findByEmail(driverLoginDto.getEmail());
        if(driver == null){
            return "Driver does not exist";
        }
        if(driver.getPasswordHash().equals(driverLoginDto.getPasswordHash())){
            return "Driver Successfully Logged";
        }
        else {
            return "Password is Wrong. Retry!!!";
        }
    }
}
