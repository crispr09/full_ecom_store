package com.fishmarket.auth;

import com.fishmarket.dto.SignupRequest;
import com.fishmarket.dto.UserDto;
import com.fishmarket.entity.User;
import com.fishmarket.enums.UserRole;
import com.fishmarket.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser (SignupRequest signupRequest) {
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole("CUSTOMER");
        User repoUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(repoUser.getId());
        return userDto;
    }
    public Boolean hasUserWithEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
    @PostConstruct
    public void createAdminAccount() {
        Optional<User> admin = userRepository.findByRole("ADMIN");
        if(admin.isEmpty()) {
            User user = new User();
            user.setName("admin");
            user.setEmail("admin@panchayat.com");
            user.setRole("ADMIN");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }
}
