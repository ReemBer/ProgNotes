package by.bsuir.prognotes.model.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 30.11.2017 13:02
 */
@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long Id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String image;

    @Column
    private String content;

    @Column
    private double rating;

    @ManyToOne
    @JoinColumn
    private User user;
}
