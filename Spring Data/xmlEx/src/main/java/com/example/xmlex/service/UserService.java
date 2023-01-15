package com.example.xmlex.service;

import com.example.xmlex.model.dto.UserSeedDto;

import java.util.List;

public interface UserService {
    long getUserCount();

    void seedUsers(List<UserSeedDto> users);
}
