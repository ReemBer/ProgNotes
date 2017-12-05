package by.bsuir.prognotes.mapper.impl;

import by.bsuir.prognotes.mapper.Mapper;
import by.bsuir.prognotes.model.db.Post;
import by.bsuir.prognotes.model.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 05.12.2017 7:51
 */
@Component
@RequiredArgsConstructor
public class PostMapper extends Mapper<Post, PostDto> {

    @Override
    public Post parseDto(PostDto dto) {
        return modelMapper.map(dto, Post.class);
    }

    @Override
    public PostDto buildDto(Post entity) {
        return modelMapper.map(entity, PostDto.class);
    }
}
