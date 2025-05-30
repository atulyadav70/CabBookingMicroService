package com.cbs.User;

import com.cbs.User.Service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class test {
    @Autowired
    private EmailService emailService;

    @Test
    void  testSendMail(){
        emailService.sendMail("atul40282@gmail.com","Testing Java mail Sender","Hello Bhosdike testing chl  rhi ");
    }
}
