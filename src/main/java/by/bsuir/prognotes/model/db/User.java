package by.bsuir.prognotes.model.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 29.11.2017 17:47
 */
@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Boolean isBlocked = false;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
