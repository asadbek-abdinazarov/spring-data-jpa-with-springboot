package uz.javachi.spring_data_jpa_with_spring_boot.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.javachi.spring_data_jpa_with_spring_boot.dtos.PostCreateDTO;
import uz.javachi.spring_data_jpa_with_spring_boot.mappers.PostMapper;
import uz.javachi.spring_data_jpa_with_spring_boot.models.Post;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostMapper postMapper;

    public PostController(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @PostMapping
    public Post create(@RequestBody PostCreateDTO dto){
        return postMapper.fromDto(dto);
    }

}
