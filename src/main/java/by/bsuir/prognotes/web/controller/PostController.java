package by.bsuir.prognotes.web.controller;

import by.bsuir.prognotes.model.dto.PostDto;
import by.bsuir.prognotes.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 30.11.2017 12:46
 */
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/post")
public class PostController {

    private final PostService postService;

    @GetMapping(value = "/all")
    public List<PostDto> getAll() {
        return postService.getAll();
    }

    @GetMapping(value = "/{id}")
    public PostDto getOne(@PathVariable Long id) {
        return postService.getOne(id);
    }

    @GetMapping(value = "/page/{size}/{number}")
    public List<PostDto> getPage(@PathVariable(name = "size") Integer size,
                                 @PathVariable(name = "number") Integer number) {
        return postService.getPage(size, number);
    }

    @PostMapping(value = "/create")
    public PostDto createPost(@RequestBody PostDto newPost) {
        return postService.create(newPost);
    }

    @PostMapping(value = "/update")
    public PostDto updatePost(@RequestBody PostDto post) {
        return postService.update(post);
    }
}

