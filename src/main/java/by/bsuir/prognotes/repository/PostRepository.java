package by.bsuir.prognotes.repository;

import by.bsuir.prognotes.model.db.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 05.12.2017 7:41
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllByOrderByIdDesc(Pageable pageable);
}
