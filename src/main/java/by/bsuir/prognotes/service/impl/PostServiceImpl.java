package by.bsuir.prognotes.service.impl;

import by.bsuir.prognotes.mapper.Mapper;
import by.bsuir.prognotes.model.db.Post;
import by.bsuir.prognotes.model.dto.PostDto;
import by.bsuir.prognotes.repository.PostRepository;
import by.bsuir.prognotes.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 30.11.2017 13:04
 */
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final Mapper<Post, PostDto> postMapper;

    @Override
    public List<PostDto> getAll() {
        return postMapper.buildDtoList(postRepository.findAll(new Sort(Sort.Direction.DESC)));
    }

    @Override
    public PostDto getOne(Long id) {
        return postMapper.buildDto(postRepository.findOne(id));
    }

    @Override
    public List<PostDto> getPage(int size, int number) {
        Pageable pageable = new PageRequest(number, size);
        Page<Post> page = postRepository.findAllByOrderByIdDesc(pageable);
        return postMapper.buildDtoList(page.getContent());
    }

    @Override
    public PostDto create(PostDto newPost) {
        Post post = postRepository.saveAndFlush(postMapper.parseDto(newPost));
        return postMapper.buildDto(post);
    }

    @Override
    public PostDto update(PostDto post) {
        return create(post);
    }
}
