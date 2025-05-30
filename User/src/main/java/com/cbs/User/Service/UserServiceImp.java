package com.cbs.User.Service;

import com.cbs.User.Entity.User;
import com.cbs.User.Exceptions.IncorrectPasswordException;

import com.cbs.User.Exceptions.UserDoesNotExistException;
import com.cbs.User.RideClient.RideClient;
import com.cbs.User.dto.RideDto;
import com.cbs.User.dto.UserLoginDto;
import com.cbs.User.dto.UserProfileDto;
import org.modelmapper.ModelMapper;

import com.cbs.User.Repository.UserRepository;
import com.cbs.User.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RideClient rideClient;

    @Autowired
    EmailService emailService;
    @Override
    public UserRegistrationDto registerUser(UserRegistrationDto userRegistrationDto) {
        User user = modelMapper.map(userRegistrationDto, User.class);
        String email = userRegistrationDto.getEmail();
        String body = "Dear " + userRegistrationDto.getFirstName() +" Bhosdike " + ",\n\n" + // Add the username here
                "Thank you for registering with us! Apni Ma n Chudayi Please.\n\n" +
                "Here are your registration details:\n" +
                "Username: " + userRegistrationDto.getFirstName() + "\n" + // Example: include username again
                "Email: " + userRegistrationDto.getEmail() + "\n\n" + // Example: include email
                "We look forward to seeing you active on our platform.\n\n" +
                "Best regards,\n" +
                "Your Team \n"+
                "ApexRide"
                ;
        String Subject = "Hello "+userRegistrationDto.getFirstName()+" Bhosdike";
        emailService.sendMail(email,Subject,body);

        user.setLastProfileUpdate(LocalDateTime.now());
        user.setRegistrationDate(LocalDateTime.now());
        User Saveduser = userRepository.save(user);
        UserRegistrationDto userSavedDto = modelMapper.map(Saveduser, UserRegistrationDto.class);
        return userSavedDto;


    }

    @Override
    public String login(UserLoginDto userLoginDto) throws UserDoesNotExistException, IncorrectPasswordException {
        User userInfo = userRepository.findByEmail(userLoginDto.getEmail());


        if (userInfo == null) {
            throw new UserDoesNotExistException();
        }
        if (userInfo.getPasswordHash().equals(userLoginDto.getPasswordHash())) {
            emailService.sendMail("atul40282@gmail.com","Testing Java mail Sender","Hello Bhosdike testing chl  rhi ");

            return "User Logged In Successfully";
        } else {
            throw new IncorrectPasswordException("Incorrect Password for user: " + userLoginDto.getEmail());
        }
    }


    @Override
    public UserProfileDto getUserProfile(Long id) {
        Optional<User> user = userRepository.findById(id);
        UserProfileDto userDto = modelMapper.map(user.get(), UserProfileDto.class);
        return userDto;
    }

    @Override
    public List<RideDto> getUsersRides(long id) {
        List<RideDto> rideDetails = rideClient.getUsersRides(id);
        return rideDetails;
    }
}
