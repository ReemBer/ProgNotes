package by.bsuir.prognotes.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 30.11.2017 13:03
 */
@Component
@Getter
@Setter
public class PostDto {

    private Long id;
    private String title;
    private String image;
    private String content;
    private Double totalRating;
}
