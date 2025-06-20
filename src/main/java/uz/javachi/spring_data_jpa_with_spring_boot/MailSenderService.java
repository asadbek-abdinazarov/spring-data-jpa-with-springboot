package uz.javachi.spring_data_jpa_with_spring_boot;

import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Map;


@Component
public class MailSenderService {

    private final JavaMailSender mailSender;

    private final Configuration configuration;

    public MailSenderService(JavaMailSender mailSender, Configuration configuration) {
        this.mailSender = mailSender;
        this.configuration = configuration;
    }

   /* @Async
    public void sendMail(String username) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        mimeMessage.setFrom("javachiuz@gmail.com");
        mimeMessage.setRecipients(Message.RecipientType.TO, "to@gmail.com");
//        mimeMessage.setText("Hello from Javachi");
        mimeMessage.setSubject("Test from Javachi");
        mimeMessage.setContent("<h1 style=\"color=BLUE\">Hello from Javachi<h1/>", "text/html;charset=utf-8");

        mailSender.send(mimeMessage);
    }

    @Async
    public void sendMailHtml(String username) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        Path path = Path.of("src/main/resources/templates/index.html");
        mimeMessage.setFrom("javachiuz@gmail.com");
        mimeMessage.setRecipients(Message.RecipientType.TO, "to@gmail.com");
        mimeMessage.setSubject("Hi " + username);

        String htmlContent = Files.readString(path);
        htmlContent = htmlContent.formatted(username);

        mimeMessage.setContent(htmlContent, "text/html;charset=utf-8");

        mailSender.send(mimeMessage);
    }

    @Async
    public void sendMailAttachment(String username) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");

        mimeMessageHelper.setFrom("javachiuz@gmail.com");
        mimeMessageHelper.setTo("to@gmail.com");
        mimeMessageHelper.setSubject("Hi " + username);
        mimeMessageHelper.setText(Files.readString(Path.of("src/main/resources/templates/index.html")).formatted(username), true);

        Path image = Path.of("src/main/resources/static/1736258550766.jpeg");

        FileSystemResource fileSystemResource = new FileSystemResource(image);
        mimeMessageHelper.addAttachment("Asadbek.jpeg", fileSystemResource);

        mailSender.send(mimeMessage);
    }

    @Async
    public void sendMailImage(String username) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");

        mimeMessageHelper.setFrom("javachiuz@gmail.com");
        mimeMessageHelper.setTo("to@gmail.com");
        mimeMessageHelper.setSubject("Hi " + username);
        String html = Files.readString(Path.of("src/main/resources/templates/index.html"));

        Path image = Path.of("src/main/resources/static/1736258550766.jpeg");
//        Base64.Encoder encoder = Base64.getEncoder();
//        String imageBase64 = encoder.encodeToString(Files.readAllBytes(image));

        mimeMessageHelper.addInline("image_id", new FileSystemResource(image));
        mimeMessageHelper.setText(html.formatted(username), true);


        mailSender.send(mimeMessage);
    }

    @Async
    public void sendMailHtmlWithFreeMaker(String username) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");

        mimeMessageHelper.setFrom("javachiuz@gmail.com");
        mimeMessageHelper.setTo("to@gmail.com");
        mimeMessageHelper.setSubject("Hi " + username);

        String token = Base64.getEncoder().encodeToString((username).getBytes());
        Template template = configuration.getTemplate("index2.ftlh");
        Map<String, String> keyMap = Map.of("username", username, "token", token);
        String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, keyMap);

        mimeMessageHelper.setText(htmlContent, true);

        mailSender.send(mimeMessage);
    }*/
}
