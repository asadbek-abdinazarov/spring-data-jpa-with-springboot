package uz.javachi.spring_data_jpa_with_spring_boot;

import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/api/mail")
public class MailSenderController {

//    private final Logger log = LoggerFactory.getLogger(MailSenderController.class);


    @PostMapping("/send")
    public String sendMail(@RequestParam String username) throws MessagingException {
//        mailSenderService.sendMail(username);
        for (int i = 0; i < 100; i++) {
            log.info("send Sending mail to {}, Time: {}", username, new Date());
        }
        return "Message Sent";
    }
    @PostMapping("/html-send")
    public String sendMailHtml(@RequestParam String username) throws Exception {
//        mailSenderService.sendMailHtml(username);
        log.info("html-send Sending mail to {}", username);
        return "Message Sent";
    }

    @PostMapping("/html-send-with-free-maker")
    public String sendMailHtmlWithFreeMaker(@RequestParam String username) throws Exception {
//        mailSenderService.sendMailHtmlWithFreeMaker(username);
        log.info("html-send-with-free-maker Sending mail to {}", username);
        return "Message Sent";
    }

    @PostMapping("/attachment-send")
    public String sendMailAttachment(@RequestParam String username) throws Exception {
//        mailSenderService.sendMailAttachment(username);
        return "Message Sent";
    }

    @PostMapping("/image-send")
    public String sendMailImage(@RequestParam String username) throws Exception {
//        mailSenderService.sendMailImage(username);
        return "Message Sent";
    }
}
