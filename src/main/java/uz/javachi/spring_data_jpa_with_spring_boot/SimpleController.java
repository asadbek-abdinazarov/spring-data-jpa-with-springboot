package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SimpleController {

    private final ReportSenderService reportSenderService;
    private final PostRepository postRepository;

    public SimpleController(ReportSenderService reportSenderService, PostRepository postRepository) {
        this.reportSenderService = reportSenderService;
        this.postRepository = postRepository;
    }

    @GetMapping("/sendReport")
    public String sendReport() {
        reportSenderService.sendReport("Asadbek");
        return "Report sent successfully";
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
