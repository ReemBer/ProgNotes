package by.bsuir.prognotes.model.db;

import lombok.*;

import javax.persistence.*;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 10.09.2017 17:00
 */
@Entity
@Table(name = "unconfirmed_registration_data")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "image")
    private String image;

    @Column(name = "expiration_time")
    private Long expirationTime;

    @Column(name = "registration_hash")
    private String registrationHash;
}
