package com.ferrisys.service.business;

import com.ferrisys.common.dto.QuoteDTO;

import java.util.List;
import java.util.UUID;

public interface QuoteService {
    void saveOrUpdate(QuoteDTO dto);
    void disable(UUID id);
    List<QuoteDTO> list();
}
