package com.ferrisys.controller;

import com.ferrisys.common.dto.QuoteDTO;
import com.ferrisys.service.business.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;

    @PostMapping("/save")
    public void save(@RequestBody QuoteDTO dto) {
        quoteService.saveOrUpdate(dto);
    }

    @PostMapping("/disable")
    public void disable(@RequestParam UUID id) {
        quoteService.disable(id);
    }

    @GetMapping("/list")
    public List<QuoteDTO> list() {
        return quoteService.list();
    }
}
