package by.asckarugin.service;

import by.asckarugin.dto.UserRegistrationDto;
import by.asckarugin.entity.User;
import by.asckarugin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User create(UserRegistrationDto dto){
        User user = User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();
        return userRepository.save(user);
    }
}
