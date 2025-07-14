package com.ferrisys.controller;

import com.ferrisys.common.dto.PurchaseDTO;
import com.ferrisys.service.business.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/save")
    public void save(@RequestBody PurchaseDTO dto) {
        purchaseService.saveOrUpdate(dto);
    }

    @PostMapping("/disable")
    public void disable(@RequestParam UUID id) {
        purchaseService.disable(id);
    }

    @GetMapping("/list")
    public List<PurchaseDTO> list() {
        return purchaseService.list();
    }
}
