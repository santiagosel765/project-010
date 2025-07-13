package com.ferrisys.service;

import com.ferrisys.common.dto.AuthResponse;
import com.ferrisys.common.dto.ModuleDTO;
import com.ferrisys.common.dto.RegisterRequest;
import com.ferrisys.common.entity.user.AuthUserRole;
import com.ferrisys.common.entity.user.User;

import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    void changePassword(Long userId, String newPassword, String confirmPassword);

    User getAuthUser(String username);

    AuthUserRole getUserRole(Long userId);

    AuthResponse registerUser(RegisterRequest request);

    AuthResponse authenticate(String username, String password);

    AuthResponse recoverPassword(String newPassword, String confirmPassword, String userToken);

    List<ModuleDTO> getModulesForCurrentUser();

}
