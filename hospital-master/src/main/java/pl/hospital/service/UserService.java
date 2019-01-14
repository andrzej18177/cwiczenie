package pl.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.hospital.dto.UserDto;
import pl.hospital.entity.User;
import pl.hospital.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public boolean userExists(String login) {
        return userRepository.existsByLogin(login);
    }

    public void createNewUser(UserDto us) {
        User user = new User();
        user.setFirstName(us.getFirstName());
        user.setLastName(us.getLastName());
        user.setLogin(us.getLogin());

        user.setPassword(passwordEncoder.encode(us.getPassword()));

        userRepository.save(user);
    }
}
