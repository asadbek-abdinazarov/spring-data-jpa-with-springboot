package uz.javachi.spring_data_jpa_with_spring_boot;

import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/api/mail")
public class MailSenderController {


    @PostMapping("/send")
    public String sendMail(@RequestParam String username) throws MessagingException {
        log.info("Sending mail to {}", username);
        return "Message Sent";
    }

    @PostMapping("/html-send")
    public String sendMailHtml(@RequestParam String username) throws Exception {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Error while sending mail");
        } else
            log.info("Sending html to {}", username);
        return "Message Sent";
    }

    @PostMapping("/html-send-with-free-maker")
    public String sendMailHtmlWithFreeMaker(@RequestParam String username) throws Exception {
        return "Message Sent";
    }

    @PostMapping("/attachment-send")
    public String sendMailAttachment(@RequestParam String username) throws Exception {
        return "Message Sent";
    }

    @PostMapping("/image-send")
    public String sendMailImage(@RequestParam String username) throws Exception {
        return "Message Sent";
    }
}
