package com.ferrisys.service.business;

import com.ferrisys.common.dto.ProviderDTO;

import java.util.List;

public interface ProviderService {
    void saveOrUpdate(ProviderDTO dto);
    void disable(Integer id);
    List<ProviderDTO> list();
}
