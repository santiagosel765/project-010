package com.ferrisys.controller;

import com.ferrisys.common.dto.ProviderDTO;
import com.ferrisys.service.business.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/providers")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @PostMapping("/save")
    public void save(@RequestBody ProviderDTO dto) {
        providerService.saveOrUpdate(dto);
    }

    @PostMapping("/disable")
    public void disable(@RequestParam Integer id) {
        providerService.disable(id);
    }

    @GetMapping("/list")
    public List<ProviderDTO> list() {
        return providerService.list();
    }
}
