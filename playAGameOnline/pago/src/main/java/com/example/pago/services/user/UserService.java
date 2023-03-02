package com.example.pago.services.user;

import com.example.pago.domains.dto.bindings.UserLoginDto;
import com.example.pago.domains.dto.bindings.UserRegisterDto;
import com.example.pago.domains.dto.models.UserDto;
import com.example.pago.services.init.DatabaseInitService;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

public interface UserService extends DatabaseInitService {
    List<String> getAllGenders();

    List<String> getRolesLowerThan(String roleName);

    UserDto registerUser(UserRegisterDto userRegisterDto);
    UserDto loginUser(UserLoginDto userLoginDto);
    List<UserDto> getUsersWithLowerRoleThan(String role);

    Integer getUserRole(Long custId);

    Optional<UserDto> getById(Long id);

    void logout(HttpSession session);
}
