package by.bsuir.prognotes.service;

import by.bsuir.prognotes.model.dto.PostDto;

import java.util.List;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 30.11.2017 13:06
 */
public interface PostService {
    List<PostDto> getAll();
    PostDto getOne(Long id);
    List<PostDto> getPage(int size, int number);
    PostDto create(PostDto newPost);
    PostDto update(PostDto post);
}
