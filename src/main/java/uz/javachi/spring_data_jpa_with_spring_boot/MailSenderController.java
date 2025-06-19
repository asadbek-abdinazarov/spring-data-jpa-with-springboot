package uz.javachi.spring_data_jpa_with_spring_boot;

import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class MailSenderController {

    private final MailSenderService mailSenderService;

    public MailSenderController(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    @PostMapping("/send")
    public String sendMail(@RequestParam String username) throws MessagingException {
        mailSenderService.sendMail(username);
        return "Message Sent";
    }
    @PostMapping("/html-send")
    public String sendMailHtml(@RequestParam String username) throws Exception {
        mailSenderService.sendMailHtml(username);
        return "Message Sent";
    }

    @PostMapping("/html-send-with-free-maker")
    public String sendMailHtmlWithFreeMaker(@RequestParam String username) throws Exception {
        mailSenderService.sendMailHtmlWithFreeMaker(username);
        return "Message Sent";
    }

    @PostMapping("/attachment-send")
    public String sendMailAttachment(@RequestParam String username) throws Exception {
        mailSenderService.sendMailAttachment(username);
        return "Message Sent";
    }

    @PostMapping("/image-send")
    public String sendMailImage(@RequestParam String username) throws Exception {
        mailSenderService.sendMailImage(username);
        return "Message Sent";
    }
}
