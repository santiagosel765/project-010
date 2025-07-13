package com.ferrisys.controller;

import com.ferrisys.common.dto.ModuleDTO;
import com.ferrisys.service.impl.ModuleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/modules")
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleServiceImpl moduleService;

    @PostMapping("/save")
    public void saveOrUpdate(@RequestBody ModuleDTO dto) {
        moduleService.saveOrUpdate(dto);
    }

    @GetMapping("/list")
    public List<ModuleDTO> getAll() {
        return moduleService.getAll();
    }

    @PostMapping("/disable")
    public void disable(@RequestParam Integer id) {
        moduleService.disableModule(id);
    }
}
