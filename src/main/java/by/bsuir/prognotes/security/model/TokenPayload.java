package by.bsuir.prognotes.security.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 07.09.2017 12:41
 */
@Getter
@Setter
@NoArgsConstructor
public class TokenPayload {

    private Long userId;
    private long expiration;

    public TokenPayload(final Long userId, final long expiration) {
        this.userId = userId;
        this.expiration = expiration;
    }
}
