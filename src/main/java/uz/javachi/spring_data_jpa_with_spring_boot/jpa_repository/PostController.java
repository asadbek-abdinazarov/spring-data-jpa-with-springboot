package uz.javachi.spring_data_jpa_with_spring_boot.jpa_repository;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostRepository repository;

    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Post> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public List<Post> getAllByCreatorId(@PathVariable("id") Integer userId) {
        return repository.findAllByUserId(userId);
    }

    @GetMapping("/sort_by_id")
    public List<Post> getAllPostsSortById() {
//        Sort sort = Sort.by(Sort.Direction.DESC, "title").and( Sort.by(Sort.Direction.ASC, "id") );
        Sort.Order title = Sort.Order.asc("title");
        Sort.Order id = Sort.Order.asc("id");
        return repository.findAll(Sort.by(title, id));
    }
}
