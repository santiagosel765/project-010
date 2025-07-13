package com.ferrisys.repository;

import com.ferrisys.common.entity.user.AuthModule;
import com.ferrisys.common.entity.user.AuthRoleModule;
import com.ferrisys.common.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleModuleRepository extends JpaRepository<AuthRoleModule, Integer> {
    void deleteByRole(Role role);

    @Query("SELECT rm.module FROM AuthRoleModule rm WHERE rm.role.id = :roleId AND rm.status = 1")
    List<AuthModule> findModulesByRoleId(Integer roleId);
}