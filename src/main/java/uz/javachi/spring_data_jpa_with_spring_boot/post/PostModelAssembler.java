package uz.javachi.spring_data_jpa_with_spring_boot.post;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PostModelAssembler implements RepresentationModelAssembler<Post, EntityModel<Post>> {
    @Override
    public EntityModel<Post> toModel(Post post) {
        Link selfLink = linkTo(methodOn(PostController.class).getPost(post.getId())).withSelfRel();
        Link postsLink = linkTo(methodOn(PostController.class).getAll()).withRel("posts");

        return EntityModel.of(post, selfLink, postsLink);
    }

    @Override
    public CollectionModel<EntityModel<Post>> toCollectionModel(Iterable<? extends Post> posts) {


        Link postsLink = linkTo(methodOn(PostController.class).getAll()).withRel("posts");

        List<EntityModel<Post>> entityModels = new ArrayList<>();
        posts.forEach(post -> entityModels.add(toModel(post)));
        return CollectionModel.of(entityModels, postsLink);

    }
}
