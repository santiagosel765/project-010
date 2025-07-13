package com.ferrisys.service.impl;

import com.ferrisys.common.dto.RoleDTO;
import com.ferrisys.common.entity.user.AuthModule;
import com.ferrisys.common.entity.user.AuthRoleModule;
import com.ferrisys.common.entity.user.Role;
import com.ferrisys.repository.ModuleRepository;
import com.ferrisys.repository.RoleModuleRepository;
import com.ferrisys.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl {

    private final RoleRepository roleRepository;
    private final ModuleRepository moduleRepository;
    private final RoleModuleRepository roleModuleRepository;

    @Transactional
    public void saveOrUpdate(RoleDTO dto) {
        Role role;
        if (dto.getId() != null) {
            role = roleRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
            role.setName(dto.getName());
            role.setDescription(dto.getDescription());
            role.setStatus(dto.getStatus());
        } else {
            role = Role.builder()
                    .name(dto.getName())
                    .description(dto.getDescription())
                    .status(dto.getStatus() != null ? dto.getStatus() : 1)
                    .build();
        }

        Role saved = roleRepository.save(role);

        // actualiza los módulos asociados
        roleModuleRepository.deleteByRole(saved);
        if (dto.getModuleIds() != null) {
            for (Integer moduleId : dto.getModuleIds()) {
                AuthModule module = moduleRepository.findById(moduleId)
                        .orElseThrow(() -> new RuntimeException("Módulo no encontrado"));
                roleModuleRepository.save(AuthRoleModule.builder()
                        .role(saved)
                        .module(module)
                        .status(1)
                        .build());
            }
        }
    }

    public List<RoleDTO> getAll() {
        return roleRepository.findAll().stream()
                .map(role -> RoleDTO.builder()
                        .id(role.getId())
                        .name(role.getName())
                        .description(role.getDescription())
                        .status(role.getStatus())
                        .build())
                .toList();
    }

    @Transactional
    public void disableRole(Integer id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        role.setStatus(0);
        roleRepository.save(role);
    }
}
