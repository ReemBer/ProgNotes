package by.bsuir.prognotes.security.service;

import by.bsuir.prognotes.exception.auth.UserNotFoundException;
import by.bsuir.prognotes.exception.registration.UnconfirmedUserException;
import by.bsuir.prognotes.model.db.RegistrationData;
import by.bsuir.prognotes.model.db.User;
import by.bsuir.prognotes.repository.RegistrationDataRepository;
import by.bsuir.prognotes.repository.UserRepository;
import by.bsuir.prognotes.security.model.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 07.09.2017 14:24
 */
@Service
@RequiredArgsConstructor
public class JwtUserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;
    private final RegistrationDataRepository registrationDataRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = this.userRepository.findUserByUsername(username);
        if (byUsername == null) {
            RegistrationData registrationData = registrationDataRepository.findByUsername(username);
            if (registrationData == null) {
                throw new UserNotFoundException("User not found.");
            } else {
                throw new UnconfirmedUserException();
            }
        } else {
            return new JwtUserDetails(byUsername);
        }
    }
}
