package com.ferrisys.repository;

import com.ferrisys.common.entity.user.AuthModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<AuthModule, Integer> {

}