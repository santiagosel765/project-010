package com.ferrisys.service.business;

import com.ferrisys.common.dto.ProviderDTO;

import java.util.List;
import java.util.UUID;

public interface ProviderService {
    void saveOrUpdate(ProviderDTO dto);
    void disable(UUID id);
    List<ProviderDTO> list();
}
