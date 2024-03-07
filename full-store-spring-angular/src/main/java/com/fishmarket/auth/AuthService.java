package com.fishmarket.auth;

import com.fishmarket.dto.SignupRequest;
import com.fishmarket.dto.UserDto;

public interface AuthService  {
    UserDto createUser (SignupRequest signupRequest);
}
