package pl.coderslab.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.User;
import pl.coderslab.exception.ValidationException;
import pl.coderslab.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private List<String> validate(User user){
        Optional<User> usernameExists = userRepository.findByUsername(user.getUsername());
        List<String> errors = new ArrayList<>();
        if(usernameExists.isPresent()){
            errors.add("Użytkownik z taką nazwą użytkownika już istnieje. Musisz wpisać inny adres e-mail");
        }
        return errors;
    }

    public User newUserRegistration(User user) throws pl.coderslab.exception.ValidationException{
        List<String> validationFailures = validate(user);
        if(validationFailures.isEmpty()){
            user.setId(null);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } else {
            throw new ValidationException(validationFailures);
        }
    }
}
