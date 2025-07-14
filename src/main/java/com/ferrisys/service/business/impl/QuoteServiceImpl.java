package com.ferrisys.service.business.impl;

import com.ferrisys.common.dto.QuoteDTO;
import com.ferrisys.common.entity.business.Client;
import com.ferrisys.common.entity.business.Quote;
import com.ferrisys.repository.ClientRepository;
import com.ferrisys.repository.QuoteRepository;
import com.ferrisys.service.business.QuoteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public void saveOrUpdate(QuoteDTO dto) {
        Quote quote = dto.getId() != null
                ? quoteRepository.findById(dto.getId()).orElse(new Quote())
                : new Quote();
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        quote.setClient(client);
        quote.setDescription(dto.getDescription());
        quote.setTotal(dto.getTotal());
        quote.setStatus(dto.getStatus() != null ? dto.getStatus() : 1);
        quoteRepository.save(quote);
    }

    @Override
    @Transactional
    public void disable(Integer id) {
        Quote quote = quoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cotización no encontrada"));
        quote.setStatus(0);
        quoteRepository.save(quote);
    }

    @Override
    public List<QuoteDTO> list() {
        return quoteRepository.findAll().stream()
                .map(q -> QuoteDTO.builder()
                        .id(q.getId())
                        .clientId(q.getClient().getId())
                        .description(q.getDescription())
                        .total(q.getTotal())
                        .status(q.getStatus())
                        .build())
                .toList();
    }
}
