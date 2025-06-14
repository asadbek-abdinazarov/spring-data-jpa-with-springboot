package uz.javachi.spring_data_jpa_with_spring_boot.jpa_repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostRepository repository;
    private final PostCustomRepository repositoryCustom;

    public PostController(PostRepository repository, PostCustomRepository repositoryCustom) {
        this.repository = repository;
        this.repositoryCustom = repositoryCustom;
    }

    @GetMapping
    public List<Post> getAll() {
        return repository.findAll();
    }

    @GetMapping("with_pageable")
    //todo: wrong way
    public List<Post> getAllWithPageable(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        return repository.findAll().stream()
                .skip((long) page * size)
                .limit(size)
                .toList();
    }

    @GetMapping("/get_all_v2")
    public Page<Post> getAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        Sort sort = Sort.by(Sort.Order.desc("title"), Sort.Order.asc("id"));
        Pageable pageable = PageRequest.of(page, size, sort);
        return repository.findAll(pageable);
    }

    @GetMapping("/get_all_v3")
    public Page<Post> getAllPageable(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        Sort sort = Sort.by(Sort.Order.desc("title"), Sort.Order.asc("id"));
        Pageable pageable = PageRequest.of(page, size, sort);
        return repository.getAllPageable(pageable);
    }

    @GetMapping("/get_all_v4/{ids}")
    public List<Post> getAllPostsByUserIds(@PathVariable("ids") Collection<Integer> ids) {
        return repository.getAllPostsByUserIds(ids);
    }


    @GetMapping("/{id}")
    public List<Post> getAllByCreatorId(@PathVariable("id") Integer userId) {
        return repository.findAllByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByUserId(@PathVariable("id") Integer userId) {
        repository.deletePostByUserId(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/sort_by_id")
    public List<Post> getAllPostsSortById() {
//        Sort sort = Sort.by(Sort.Direction.DESC, "title").and( Sort.by(Sort.Direction.ASC, "id") );
        Sort.Order title = Sort.Order.asc("title");
        Sort.Order id = Sort.Order.asc("id");
        return repository.findAll(Sort.by(title, id));
    }

    @PostMapping("/save")
    public Post save(@RequestBody Post post) {
        return repositoryCustom.save(post);
    }

    @GetMapping("/by-title/{title}")
    public ResponseEntity<List<Post>> get(@PathVariable String title) {
        return ResponseEntity.ok(repository.findAllByTitleStartingWithIgnoreCase(title));
    }
}
