package com.ferrisys.controller;

import com.ferrisys.common.dto.RoleDTO;
import com.ferrisys.service.impl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleServiceImpl roleService;

    @PostMapping("/save")
    public ResponseEntity<String> saveRole(@RequestBody RoleDTO dto) {
        roleService.saveOrUpdate(dto);
        return ResponseEntity.ok("Rol procesado correctamente");
    }

    @PostMapping("/list")
    public List<RoleDTO> listRoles() {
        return roleService.getAll();
    }

    @PostMapping("/disable")
    public ResponseEntity<String> disableRole(@RequestParam Integer roleId) {
        roleService.disableRole(roleId);
        return ResponseEntity.ok("Rol deshabilitado");
    }
}