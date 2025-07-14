package com.ferrisys.controller;

import com.ferrisys.common.dto.ClientDTO;
import com.ferrisys.service.business.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/save")
    public void save(@RequestBody ClientDTO dto) {
        clientService.saveOrUpdate(dto);
    }

    @PostMapping("/disable")
    public void disable(@RequestParam Integer id) {
        clientService.disable(id);
    }

    @GetMapping("/list")
    public List<ClientDTO> list() {
        return clientService.list();
    }
}
