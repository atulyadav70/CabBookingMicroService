package com.cbs.User.Service;

import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException; // Import this for better error handling
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async; // Import Async
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;
import jakarta.mail.MessagingException; // Import for MimeMessageHelper
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Async // Mark this method to be executed in a separate thread
    public void sendMail(String to, String subject, String body) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(body);
            javaMailSender.send(mail);
            log.info("Email sent successfully to: {}", to); // Add a success log
        } catch (MailSendException e) { // Catch specific email sending exceptions
            log.error("Failed to send email to {}: {}", to, e.getMessage(), e);
            // You might want to log the full stack trace for debugging,
            // or even retry the email sending logic here.
        } catch (Exception e) {
            log.error("An unexpected error occurred while sending email to {}: {}", to, e.getMessage(), e);
        }


    }

    public void sendHtmlMail(String to, String subject, String templateName, java.util.Map<String, Object> templateVariables) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, "UTF-8");

            Context context = new Context();
            context.setVariables(templateVariables);

            String htmlContent = templateEngine.process(templateName, context); // Process the template

            helper.setFrom("your_email@example.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true); // Set true for HTML content

            mailSender.send(mimeMessage);
            System.out.println("HTML email sent successfully to: " + to + " using template: " + templateName);
        } catch (MessagingException e) {
            System.err.println("Error sending HTML email: " + e.getMessage());
            // Handle exception appropriately
        }
    }
}