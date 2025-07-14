package com.ferrisys.service.business;

import com.ferrisys.common.dto.QuoteDTO;

import java.util.List;

public interface QuoteService {
    void saveOrUpdate(QuoteDTO dto);
    void disable(Integer id);
    List<QuoteDTO> list();
}
